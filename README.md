
# Spring Boot Movie Application

The project is a movie application providing users with the functionalities which will help them decide on a movie to watch. The application will have different roles access for specific functions such as the management of cinemas.

## Tech Stack

**Client Side:** Vue.js Thymeleaf BootStrap HTML 

**Server Side:** Spring Boot Spring JPA MYSQL  Spring Security


## What You Need
- IDE 
- JDk 1.8 Or Later
- Grade 4+  Or Maven 3.2+
## Installing Spring Boot
- Navigate to https://start.spring.io. This service pulls in all the dependencies you need for an application and does most of the setup for you.
- Choose either Gradle or Maven and the language you want to use. This guide assumes that you chose Java.
- Click Dependencies and select Spring Web , Spring Jpa , Spring Dev Tools , Spring Security , MSQL Connector , Thymeleaf.
- Click Generate.
- Download the resulting ZIP file, which is an archive of a web application that is configured with your choices.


## Authors

- [@rodgerskaunda](https://github.com/foreveryoung21)


## API Reference

#### OMDB API 

Below is an example of movie searh to api OMDB. For more information on how to use the API follow link in the documentation.

```
  GET https://www.omdbapi.com/?s='+movie+'&api_key=apikey
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### TheMovieDB

Below is an example of movie searh to api TheMovieDB. For more information on how to use the API follow link in the documentation.


```
  GET https://api.themoviedb.org/3/search/movie?api_key=apikey&query='+movie
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `api_key`      | `string` | **Required**. Your API Key|




## Deployment
- Create an account on heroku 

- Once account is created on heroku login with cli command

```
heroku login
```


Execute the following commands from the root directory of the project to create a local Git repository for the project 

```
git init 
git add . 
git commit -m "initial commit"
```

Now, create a new heroku app using heroku create command like so 

```
heroku create <Your app name>
```

Finally, you can deploy the app by simply pushing the code to the remote repository named heroku which was created by the heroku create command.

```
git push heroku master
```

Heroku automatically detects that the project is a Maven/Java app and triggers the build accordingly.
Once the application is deployed, you can open it using the following command 

```
heroku open
```
In order to use MySQL as the database for the application on heroku an add on of cleardb has to be used with the following command.

```
heroku addon:create cleardb:ignite
```
## Application Functionality


- Users can register/login as a regular or admin users . The different users will have different set of privledges within the application.

 <img src="https://user-images.githubusercontent.com/87673688/149159520-d5af0cbd-3fba-4f75-8ca7-a394e3ecaf25.png" width="470" height="470">.              <img src="https://user-images.githubusercontent.com/87673688/149160870-a0d5f1a8-85f1-4280-8f8d-e368671d10a3.png" width="470" height="470">
 


-  Once the user has logged in their able to search for a movie and add a movie to a watch later list.

 <img src="https://user-images.githubusercontent.com/87673688/149170180-6fa3f0e0-a5ec-49d7-8bbf-c423e65c56a3.png" >. 
 
 - Shows the movie that is added to the watch list. The watch list item can be deleted or updated by the user.
 
 <img src="https://user-images.githubusercontent.com/87673688/149170500-5b73782b-9238-4df0-bbb0-17be5dd17c3a.png" >


  -  The user can search for a movie and view the movie trailer.
 
 ![image](https://user-images.githubusercontent.com/87673688/149171392-eedf61ad-9c36-4c6e-97a9-509c404fdfcf.png)
 
 - The image below is of the selected movie trailer.
 ![image](https://user-images.githubusercontent.com/87673688/149172030-7d27a27a-a168-4cec-aa38-b165f9c3b9ec.png)

- Once the trailer is viewed by the user it will apear it the user watch history list. In the watch history section it can be deleted or viewed again.

![image](https://user-images.githubusercontent.com/87673688/149172361-f5dfe7dc-69bd-4260-81e7-0465a8d54a84.png)



- Users are able to comapare searched movies side by side. The comparison can be made for a single or all input fields.

![image](https://user-images.githubusercontent.com/87673688/149173694-4daa6de5-3a8a-4b68-bae0-e21efc34d376.png)


- The applciation has restricts regular users from accessing adminstrator functionality such as add cinema and view cinema list.

 ![image](https://user-images.githubusercontent.com/87673688/149174306-642ddde5-a7bc-470b-937d-9e34eabe6d3a.png)


- The admin users are able to create a new cinema on the application.

![image](https://user-images.githubusercontent.com/87673688/149174932-34940241-ff52-4f09-8a0c-e206c91257ea.png)

- Once the cinema is added to the cinemas lists the admin is able to either delete or update cinema item.

 ![image](https://user-images.githubusercontent.com/87673688/149175091-76fafa9f-84a1-49c2-8a10-d65fe5fedb85.png)
 
 
 - Once the user has completed all the tasks they are able to log out the application.
 
 ![image](https://user-images.githubusercontent.com/87673688/149175709-363324cb-0f2b-449d-9e4c-ab0986e149b9.png)


## Lessons Learned

- How to transfer data from the front end to backend
- How to third party API's.
- How to use rest protocols.
- How to create an application using MVC pattern.
- How to deploy the application the cloud using heroku.


## Documentation

[OMDB API](https://www.omdbapi.com/)

[TheMovieDB API](https://developers.themoviedb.org/3/movies/get-movie-details)




## Hosted Application On Heroku
The movie application can be found following the link with heroku.

https://springboot-movie-application.herokuapp.com
