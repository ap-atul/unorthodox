import { DataToWrite } from './types';
import { createHash } from 'crypto';
import fs from 'fs';


export const getFormattedData = (obj: any): DataToWrite => {
  const id = getHash(obj.title);
  const passages = getPassages(obj.title);
  console.log("total passages found: ", passages.length);
  return {
    id: id,
    story: {
      id: id,
      title: obj.title,
      subtitle: obj.subtitle,
      art: obj.art,
      timestamp: new Date(),
    },
    storyDetails: {
      id: id,
      passages: passages,
      references: obj.references,
    }
  };
};

const getPassages = (title: string): string[] => {
  const legendId = title.split(" ").join("-").toLowerCase();
  const passageText = fs.readFileSync(`./res/${legendId}/passage.txt`);
  return passageText.toString().split("\n\n");
}

const getHash = (title: string): string => {
  return createHash('md5').update(title).digest('hex');
};
