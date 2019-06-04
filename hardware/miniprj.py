from ubidots import ApiClient
import serial
ser = serial.Serial('COM4',9600)
while True:

    x=ser.readline()

    level=x
    api = ApiClient(token='BBFF-vFprQFwcgyngSVuButF46pQjgTICru')
#    my_variable = api.get_variable('5af7ff0bc03f9733631295b1')
    my_variable = api.get_variable('5bcf262d1d847209320a5a76')
    try:

        ab=level.decode('ASCII')
        print(ab)
        my_variable = api.get_variable('5bcf262d1d847209320a5a76')
 #       my_variable1 = api.get_variable('5afd8555c03f9727d95dfa85')
 #       new_value = my_variable.save_value({"value": flow})

        new_value = my_variable.save_value({"value":ab})

    except ValueError:
        print("No JSON received")
