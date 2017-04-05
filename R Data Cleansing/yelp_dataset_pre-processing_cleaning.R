#ADBMS: Hadoop MapReduce Final Project on Yelp Dataset for Non-personalized/personalized Recommender System
library(stringr)
#Data pre-processing code on yelp dataset source files: checkin, business, tip, user, review

#Data pre-processing and cleaning of checkin source file
checkin <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_checkin.csv")
business<-checkin$business_id
new_checkin <- as.data.frame(business)
new_checkin$type <- checkin$type 
sum(is.na(new_checkin))
colnames(new_checkin)
write.csv(new_checkin, file="cleaned_checkin_train.csv")
sum(duplicated(new_checkin$business))

#Data pre-processing and cleaning of business source file
business <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_business.csv")
business_id <- business$business_id
new_business <- as.data.frame(business_id)
new_business$name <- gsub(",", "", business$name, fixed = TRUE)
vector <- character(0)
for(i in 1:nrow(business)) {
  row <- business[i,]
  category <- row$categories
  initial <- str_replace_all(category, "u'", "")
  final <- str_replace_all(initial, "[[:punct:]]", "")
  vector[i] <- final
}
new_business$categories<- vector
new_business$state <- business$state
new_business$city <- business$city
new_business$stars <- business$stars
new_business$type <- business$type
value <- "Restaurants"
final_business <- new_business[grep(value, vector),]
sum(is.na(final_business))
colnames(final_business)
write.csv(final_business, file="cleaned_business_train.csv")

#Data pre-processing and cleaning of tip source file
tip <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_tip.csv", nrows = 500000)
user_id <- tip$user_id
new_tip <- as.data.frame(user_id)
new_tip$text <- tip$text
new_tip$business_id <- tip$business_id
new_tip$type <- tip$type
sum(is.na(new_tip))
colnames(new_tip)
write.csv(new_tip, file="cleaned_tip_train.csv")

#Data pre-processing and cleaning of user source file
user <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_user.csv", nrows = 500000)
user_id <- user$user_id
new_user <- as.data.frame(user_id)
new_user$name <- gsub(",", "", user$name, fixed = TRUE)
new_user$review_count <- user$review_count
new_user$average_stars <- user$average_stars
new_user$votes_useful <- user$votes.useful
new_user$type <- user$type
sum(is.na(new_user))
colnames(new_user)
write.csv(new_user, file="cleaned_user_train.csv")

#Data pre-processing and cleaning of review source file
review <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_review.csv", nrows = 50000, strip.white = TRUE)
review_id <- review$review_id
new_review <- as.data.frame(review_id)
new_review$user_id <- review$user_id
text <- gsub(",", "", review$text, fixed = TRUE)
text <- gsub(".", "", text, fixed = TRUE)
text <- gsub("!", "", text, fixed = TRUE)
text <- gsub("-", "", text, fixed = TRUE)
text <- gsub("(", "", text, fixed = TRUE)
text <- gsub(")", "", text, fixed = TRUE)
text <- gsub(":", "", text, fixed = TRUE)
text <- gsub("?", "", text, fixed = TRUE)
text <- gsub("$", "", text, fixed = TRUE)
new_review$text <- text
new_review$business_id <- review$business_id
new_review$stars <- review$stars
new_review$type <- review$type
sum(is.na(new_review))
colnames(new_review)
write.csv(new_review, file="cleaned_review_train.csv")

#Data pre-processing and cleaning of review source file for simple moving average
sma <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_review.csv", nrows = 500000)
review_id <- sma$review_id
new_sma <- as.data.frame(review_id)
new_sma$business_id <- sma$business_id
new_sma$date <- sma$date
new_sma$stars <- sma$stars
sum(is.na(new_sma))
colnames(new_sma)
write.csv(new_sma, file="cleaned_sma_train.csv")

#Data pre-processing and cleaning of review source file for content based recommendation
cbr <- read.csv("C:/Users/agraw/OneDrive/Documents/yelp_academic_dataset_review.csv", nrows = 1000000)
business_id <- cbr$business_id
new_cbr <- as.data.frame(business_id)
new_cbr$user_id <- cbr$user_id
new_cbr$stars <- cbr$stars
sum(is.na(new_cbr))
colnames(new_cbr)
write.csv(new_cbr, file="cleaned_cmr_train.csv")