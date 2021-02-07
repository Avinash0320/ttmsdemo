# Getting Started

Technologies used
 1. JAVA 1.8
 2. Spring boot 2.3.8.RELEASE
 3. Maven 3.6.3

To start app 
 * mvn spring-boot:run

Sample API response 
Request:

* GET service:
http://localhost:8888/api/ip?ips=192.168.0.1,24.48.0.1,175.143.231.148,24.48.0.1,8.8.8.8

* Response:
{
    "statusCode": "200 OK",
    "results": [
        "Canada",
        "United States"
    ]
}

