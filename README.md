# CS360-Mobile-App-Development
Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?
The goal of this app was to create a simple inventory tracker that allows users to log in, add items, track their quantity, and receive SMS notifications when inventory runs low. The app was designed to help small business owners or individuals who need a lightweight, no-frills way to manage stock and stay alerted when items need restocking.

What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your UI designs keep users in mind? Why were your designs successful?
To meet user needs, I designed the app with three main screens: Login/Create Account Screen – for secure, easy access. SMS Notification Permission Screen – to request SMS access clearly and respectfully, and Inventory Management Screen – where users can add, edit, delete items, and see quantities

How did you approach the process of coding your app? What techniques or strategies did you use? How could those techniques or strategies be applied in the future?
I used a step-by-step approach when building the app. I planned out the user flow first, then started coding one screen or feature at a time. I used TODO comments and small test functions to keep track of progress. This method helped me stay organized and could definitely be used again in future projects, especially ones that need to stay clean and easy to maintain.

How did you test to ensure your code was functional? Why is this process important, and what did it reveal?
I tested my code frequently by running the app on the emulator and checking each feature right after building it. I also used the Preview feature in Android Studio for UI layout testing. This testing process was important because it helped catch logical issues, especially when handling things like SMS permissions and making sure the app didn’t crash when running on an emulator without telephony support.

Consider the full app design and development process from initial planning to finalization. Where did you have to innovate to overcome a challenge?
One of the challenges I faced was getting the SMS functionality to work properly without crashing the app. I had to add permission checks and safe fallbacks to make sure the app only sent SMS when allowed. I also had to learn how to structure the app’s flow so it made sense — login first, then permission, then inventory — which improved usability.

In what specific component of your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?
I think I was most successful in demonstrating my skills through the SMS notification feature. It showed that I understood how to work with Android permissions, check for telephony support, and design around real-world limitations like emulator restrictions. This feature made the app feel more complete and practical.
