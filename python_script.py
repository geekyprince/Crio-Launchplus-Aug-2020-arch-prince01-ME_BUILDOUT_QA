import json
from pymongo import MongoClient


# Making Connection
myclient = MongoClient("mongodb://localhost:27017/")

# database
db = myclient["quiz-database"]

# check if a collection {"questions"} exists
col_exists = "questions" in db.list_collection_names()

Collection = db["questions"]
# use the database_name.some_collection.drop() method call if True
if col_exists:
    Collection.drop()

# Loading or Opening the json file
with open('initial_data_load.json') as file:
    file_data = json.load(file)


newdata = {"moduleId": "1", "questions": file_data}

# Inserting the loaded data in the Collection
# if JSON contains data more than one entry
# insert_many is used else inser_one is used
Collection.insert_one(newdata)
