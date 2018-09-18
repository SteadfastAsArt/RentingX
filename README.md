# RentingVis

## Brief Introduction
A visualization system for house renting in any city-wide region ( Data was based on Hangzhou, Zhejiang, China ). Our project mainly focuses on better user experience for hundreds of thousands of who need to choose houses for rent. We made our attempts to promote conciseness and expressiveness into our front end also with a highly efficient back end.

## Motivation
China's house renting market has gained more attention in recent years due to change of fellow citizens' intrinsic attitudes and macroeconomic policy. Chinese people usually find their target communities or, to be more accurate, houses through agents or their websites. <br>
To enumerate these, lianjia, anjuke, fangtianxia, 58tongcheng, touming, etc. They all have their data sources and a wide range of business not only focus on house renting. They provide a series of query parameters for user to select in certain conditions restricted by database fields. They also have interface on spatial queries. <br>
**RentingVis** can do more than that...

## Functions
**RentingVis** provides a friendly user interface with map as its major layout using ArcGIS api for JavaScript(3.25). <br>
You can: <br>
1. Choose your attributes of interests under certain conditions.
2. Query an region of interests to find how many houses are there and choose any certain houses to find surrounding POIs in your interests tags.
3. Have an intuitive look on how price distributed in city-wide. At the same time, we calculate a ranking model for 150m * 150m large pixel and each house have their ranking. The model contain parameters from inner to outer factors, the latter cover transport  accessibility, public service and natural environment. We hava a total score and user can also make their own priority based on which you value most.
4. Pick at most 3 places you are about to visit frequently and dont know where to settle, we will recommend you a list of houses based on route network distance and ranking model. 
5. If you are intereted in a certain community, you can query its comments data for more details.
6. Data mining, each query will present you an *overview outlook* of results and also accurate to each house's data statistics. You can easily adjust what to present on the comparison graph.

## System Design
Front-end: map using ArcGIS js api, bootstrap framework.
Back-end: SSM to manage requests and make responses.
Database: PostgreSQL + PostGIS extension

## Data Sources:
1. House attributes via @lianjia, @touming ( geographic information gained by geo-coding )
2. POIs via @baidu map
3. Route network via @OSM
4. Comments via @Anjuke

## Restrictions & Furthver Development
1. Dynamic data crawling
2. Chinese house renting market is mainly conducted through real world access and don't have an open source information presentation platform.
