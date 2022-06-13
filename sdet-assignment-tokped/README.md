Problem Description: Consider below Order object (Java Model) 
{
“order_id”:xxxxxx,
“order_description”:”sample description”,
“order_status”:”New”,
“last_updated_timestamp”:”1642321210439”, //Unix milisec
“special_order”:false
}
The object is serialized as json and sent to /processOrder() API. API returns response as Order object with updated “order_status” and “last_updated_timestamp”.

Design an automation framework to test/validate the API with possible use cases. The solution should meet the below criteria:
Solution should be scalable (Should support fast changing product features and requirements and large no of future/current test cases).
Choose efficient design patterns. Elaborate the choices in a README file.
Use OOP concepts where you see required.
Choose the techstack with consideration for Maintainability/Usability/Reporting/Readability.
Solution should adhere to SOLID principles.
README file should include the steps to run the tests, the brief description of the approach or any alternative considered and any other dependency.
What improvements would be needed for the solution  to be platform/OS independent.


Test cases:
1. Get all order details
2. Remove order id
3. Create order id
4. Update order id
