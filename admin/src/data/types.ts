export interface Story {
  id: string;
  title: string;
  subtitle: string;
  art: string;
  timestamp: any;
}

export interface StoryDetails {
  id: string;
  passages: string[];
  references: string;
}

export interface DataToWrite {
  id: string;
  story: Story;
  storyDetails: StoryDetails;
}
