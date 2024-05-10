# San Francisco Food Truck Finder
APIs for search food trucks in San Francisco City.

## REST APIs for searching food trucks database for San Francisco city
* Food trucks data for San Francisco city from [here](https://data.sfgov.org/api/views/rqzj-sfat/rows.csv) in CSV format
is loaded in the application
* This data is parsed on application startup (see comments in code for improvements) and loaded in-memory.
* "/food-trucks/search" REST endpoint for POST method finds all food trucks/carts matching the searchText in food item 
or `applicant`. Using applicant name is because some trucks/carts data does not have items list, so alternatively we 
could use 'applicant' for search.   
* I want to extend this for more searches and my idea is to add filtering for `hasValidPermit` so user can see 
only those truck/cart that has valid permit. Due to time constraint I am stopping at this point. But will add it to this 
implementation just for fun. 
* Big time TDD fan, but getting focused on a running application I missed the tests. 


## In Production, I would do ...
NOTE: there are comments in code as well that mentions improvements that can be implementation
* Database
  * cache given the size of data with refresh every scheduled frequency from the source
  * if the app were to create data then use a Database depending on various factors like frequency of reads, writes, 
    maintainability, etc.
* Security - Authentication/Authorization if we allowed sensitive information read, and definitely for writes.
* Build and deploy with CI/CD pipeline to lower environments
  * Tests, code coverage, security (vulnerability check on libraries)
  * Build OCI/Docker image once and deployed in lower environments on merge to main branch
  * Deploy/promote to higher environment depending on business requirements
* Kubernetes for deployments


## Running the app
It's a SpringBoot gradle project developed in IntelliJ Idea. Could be run directly from the IDE or through gradle command line.
Test with curl or postman:
```curl -X POST http://localhost:8080/food-trucks/search -H "Content-Type: application/json" -d "{\"searchText\": \"soup\"}"```
