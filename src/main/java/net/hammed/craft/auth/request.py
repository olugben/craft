import requests
import json

url = 'http://localhost:8090/api/v1/auth/register'
headers = {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer <your-jwt-token>'
}

data = {
    "firstname": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com",
    "password": "securepassword123",
    "role": "USER"
}

response = requests.post(url, headers=headers, data=json.dumps(data))

print(response.status_code)
print(response.text)
