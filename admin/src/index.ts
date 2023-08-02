import admin from 'firebase-admin';
import { config, constants } from './config';
import { getFormattedData } from './data';
import { createInterface } from 'readline';

import legends from '../res/legends.json';

const readLine = createInterface({
  input: process.stdin,
  output: process.stdout
});

admin.initializeApp({
  credential: admin.credential.cert(config.serviceAccountFilePath),
});

const db = admin.firestore();
const storiesCollectionReference = db.collection(constants.collections.stories);
const passagesCollectionReference = db.collection(constants.collections.passages);

const writeStories = async (stories: any[]) => {
  const batch = admin.firestore().batch();
  const ids: string[] = [];

  stories.forEach((story) => {
    const dataToWrite = getFormattedData(story);
    console.log(dataToWrite);

    ids.push(dataToWrite.id);
    const storyDocReference = storiesCollectionReference.doc(dataToWrite.id);
    const passageDocReference = passagesCollectionReference.doc(dataToWrite.id);

    batch.set(storyDocReference, dataToWrite.story);
    batch.set(passageDocReference, dataToWrite.storyDetails);
  });

  readLine.question("Should proceed to write?(y/n)", (answer) => {
    if (answer == 'y') {
      batch.commit()
        .then(() => { console.log(`Successfully written ${stories.length} documents at `, ids) })
        .catch((err) => { console.log("error :: ", err); });
    } else {
      console.log("Skipped writing..");
    }
    readLine.close();
  });
}

writeStories([
  legends['the-crying-boy'],
]).catch(console.log);
