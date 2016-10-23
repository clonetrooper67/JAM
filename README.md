# JAM: Junior Achievement Mobile
<b>Goal statement for project:</b>

Create an application for adults involved in or interested in Junior Achievement that incentivizes behavior (volunteer activities, requesting programming, etc.) and creates a social network for those involved to connect as well as share ideas and experiences.

<b>Vision for JAM:</b>

We wanted to create a place for prospective volunteers as well as teachers to be able to see some of the best experiences that both volunteers as well as teachers have had with JA.

<b>How we accomplish this:</b>

JAM is a micro-social network. Guest users are presented with a list of testimonials that have been submitted by other users. For a user to submit content, they must first create a JAM account, which requires an email address and a password.
The key behind JAM is the karma system. We needed a way to incentivize volunteers as well as teachers to continue to post content.
So users can upvote content that other users have submitted. One upvote increases your karma by one.
There is a leaderboard for "Best JA Participants", which ranks users based on their karma. This adds incentive to volunteer so that you can brag to your friends about being at the top of the JAM leaderboards (A great way to introduce people to JA).

<b>Technology:</b>

JAM is an Android app programmed in Android Studio with Java.

For the back end support, we decided to use Google's Open-Source: Firebase (Google cloud messaging)
https://github.com/firebase/

Firebase has much functionality, including:

-User-account creation and authentication

-Easy data-base access and creation in the form of JSON files.

-Image storage and access


Firebase uses propritary tokens to authenticate users:
"Created by Firebase when a user signs in to a Firebase app. These tokens are signed JWTs that securely identify a user in a Firebase project. These tokens contain basic profile information for a user, including the user's ID string, which is unique to the Firebase project. Because the integrity of ID tokens can be verified, you can send them to a backend server to identify the currently signed-in user." --Firebase Documentation

<b>To Do:</b>

-Implement Ranking Activity

-Implement Karma Counting/Sorting

-Implement Custom Profile Pages

-Implement ImageView in post layout (Already have archetecture for taking photos and submitting them, disabled for now)

