# Content Based and Personalized Restaurant Recommender System - Yelp Dataset

This is the final project for the course Advanced Hadoop MapReduce Programming (ADBMS). It is a recommending engine to recommend restaurants to users based on the dataset provided Yelp.

# Project Description

1. Developed a content based recommender system that recommends restaurants to the users.
2. Extracted the data related to restaurants from Yelp academic data-set comprising of multiple data sources.
3. Performed Data pre-processing and cleaning of the data sources in concern for building the recommender system.
4. Implemented MapReduce Design patterns like Filtering, Summarization, Data Organization and Join patterns to perform analysis and recommend restaurants.
5. Performed Sentiment analysis of the reviews about the restaurants given by Yelp users.
6. Provided results like Top restaurants by country and state, Total restaurants by country and state, Moving Average Rating of the restaurants, Top restaurants by positive reviews, Minimum and Maximum review count of each restaurants, Elite users based on useful votes by them, etc.
7. Calculated the Pearson correlation, Jaccard correlation and Cosine correlation between restaurants to recommend to users.
8. Performed Bining to split the data source on the basis of a preset value of a column and Bloom filtering to filter restaurants on the basis of cities they are located in.
9. Deployed the project on 4 AWS EC2 instances comprising of a Namenode, a Secondary Namenode and two Data nodes to achieve scalability, performance and fault tolerant Distributed computing.
10. Visualized some of the analysis using PowerBi.

# Code Implementaions

Following are the different analysis performed on the dataset:

1. [Average rating and total restaurants by cuisine](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/averageratingandtotalrestaurantsbycuisine)
2. [Content based recommendation](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/contentbasedrecommendation)
3. [Elite users based on useful votes](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/eliteusersbasedonusefulvotes)
4. [Minimun maximum total review count](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/minmaxtotalreviewcount)
5. [Restaurants by star](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/restaurantsbystar)
6. [Restaurant search using bloom filtering](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/restaurantsearchusingbloomfiltering)
7. [Sentiment analysis of use reviews](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/sentimentanalysisofuserreviews)
8. [Sentiment analysis of user reviews by restaurants](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/sentimentanalysisofuserreviewsbyrestaurants)
9. [Simple moving average rating of restaurants](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/simplemovingaverageratingofrestaurants)
10. [Tip at restaurants](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/tipatrestaurants)
11. [Top 10 restaurants by positive reviews](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/top10restaurantsbypositivereviews)
12. [Top restaurants by state](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/toprestaurantsbystate)
13. [Total and average rating of restaurants by country](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/totalandaverageratingofrestaurantsbycountry)
14. [Total restaurants by state](https://github.com/agrawal-priyank/AWS-Yelp-Recommender_Hadoop-MapReduce-Project/tree/master/RestaurantRecommenderSystem/src/edu/neu/totalrestaurantsbystate)

# Technologies

Java, R, Hadoop, HDFS, MapReduce, HBase

# Cloud & Virtualization

AWS EC2, Ubuntu, VMWare

# Visualization

PowerBI

# IDE

Eclipse, RStudio 

# Tools

WinSCP, Putty, PuttyGen
