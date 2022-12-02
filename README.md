DMATool
// This README contains documentation for the DMATool and the APIs used in it 

# *Start API*
This API takes a GET request 
This API creates an assessment for the current user & generates an 8 difit unique assessment id .
The current application initializes the value from *70000000* and generates the assessment Id incrementally.
It saves the record with the assessment Id which was generated as well as the creation Date and Time.
Also the assessment details are fetched from the Database i.e. the Category names , Assessment Duration , Assessment Duration Warning etc & also the message , status and statusCode
The values for the AssessmentDuration & AssessmentDurationWarning are fetched from application.properties file using the *@Value()* annotation
The provided id will be used throughout the assessment for interaction with various APIs 

# *Save Response API*
This API takes a POST request which includes the duration as well as the assessment question reponses .
This API is crucial as it helps in case of assessment incompletion .
The progress of the user will be saved uptill and stored into the database .
The assessment id in the request is validated & the questions are validated while saving 
Returns a success message on completion