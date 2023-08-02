import dotenv from 'dotenv';
dotenv.config();

export const config = {
  serviceAccountFilePath: process.env.SERVICE_ACCOUNT_FILE || '',
}

export const constants = {
  collections: {
    stories: "stories",
    passages: "passages",
  },
}
