import json


def hello(event, context):
    body = {
        "message":"Hola desde serverless",
        "nombre": "Paula Andrea Betancourt",
        "carrera": "Ingenieria de software",
        "Universidad": "EAM",
        "input": event,
    }

    response = {"statusCode": 200, "body": json.dumps(body)}

    return response
