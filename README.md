# Movie-Rating-Application
[![][maven img]][maven]
It is a Demo Movie rating Application using Spring framework and use eureka as load balancer and client side server discovery.It show the all movie a user watch of specific userId.
* The Application Microservices are- 
	* [`Movie-Catalog-Sevice`]
	* [`Movie-Info-Service`]
	* [`Movie-Data-Service`]
	* [`discovery-server`]. 
Movie Info servide provide information about movie given specificd movieId.
Movide Data Service provide rating data which give user after watch the movie.

At first User send request to discovery server for servises then discovery server return the url of specified microservice after that user send another request to actual server.


