## Restaurant Recommendation Enginer - Content Based and Personalized (Yelp Dataset)

### Description
* Developed a content based recommender that recommends restaurants to the users.
* Extracted, pre-processed, and cleaned the data related to restaurants from Yelp academic dataset.
* Implemented mapreduce design patterns like filtering, summarization, data organization, and join patterns to perform analysis such as top restaurants by country and state, total restaurants by country and state, moving average rating of restaurants, top restaurants by positive reviews, minimum and maximum review count of each restaurants, etc.
* Performed sentiment analysis of the reviews about the restaurants given by Yelp users.
* Calculated the pearson correlation, jaccard correlation and cosine correlation between restaurants to recommend to users.
* Performed bining to split the data source on the basis of a preset value of a column and bloom filtering to filter the restaurants on basis of cities they are located in.
* Deployed the project on AWS EC2 with 4 instances comprising of a namenode, a secondary namenode and two data nodes to achieve high scalability and performance.
* Visualized the analysis in PowerBI.

### Code
1. [Average rating and total restaurants by cuisine](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/averageratingandtotalrestaurantsbycuisine)
2. [Content based recommendation](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/contentbasedrecommendation)
3. [Elite users based on useful votes](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/eliteusersbasedonusefulvotes)
4. [Minimun maximum total review count](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/minmaxtotalreviewcount)
5. [Restaurants by star](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/restaurantsbystar)
6. [Restaurant search using bloom filtering](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/restaurantsearchusingbloomfiltering)
7. [Sentiment analysis of user reviews](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/sentimentanalysisofuserreviews)
8. [Sentiment analysis of user reviews by restaurants](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/sentimentanalysisofuserreviewsbyrestaurants)
9. [Simple moving average rating of restaurants](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/simplemovingaverageratingofrestaurants)
10. [Tip at restaurants](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/tipatrestaurants)
11. [Top 10 restaurants by positive reviews](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/top10restaurantsbypositivereviews)
12. [Top restaurants by state](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/toprestaurantsbystate)
13. [Total and average rating of restaurants by country](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/totalandaverageratingofrestaurantsbycountry)
14. [Total restaurants by state](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/tree/master/RestaurantRecommenderSystem/src/edu/neu/totalrestaurantsbystate)

### Data Preprocessing and Cleansing
* [R File]()

### Data Visualization
* Total Restaurants by Cuisine
![](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/blob/master/charts/total-number-of-restaurants-by-cuisine.JPG?raw=true)

* Top 10 Restaurants
![](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/blob/master/charts/top-10-restaurants.JPG?raw=true)

* Average Rating of Restaurants by Cuisine
![](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/blob/master/charts/average-rating-of-restaurants-by-cuisine.JPG?raw=true)

* Positive and Negative Review Count of Restaurants
![](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/blob/master/charts/positive-negative-review-count-of-restaurants.JPG?raw=true)

* Moving Average of a Restaurant
![](https://github.com/agrawal-priyank/Restaurant-Recommender-System-AWS-Hadoop-MapReduce/blob/master/charts/yearly-moving-average-of-a-restaurant.JPG?raw=true)

### Programming Language
Java, R

### Technologies
Hadoop, HDFS, MapReduce, AWS EC2, Ubuntu

### Utility Tools/IDE
Eclipse, RStudio, WinSCP, Putty, PuttyGen, PowerBI
