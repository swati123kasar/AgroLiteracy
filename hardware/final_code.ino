
    //int rainPin = A0;
    int buzzPin=11;
    int ACWATERPUMP = 13; 
    int sensor = 8; 
    int val; 
    const int trigPin = 9;
    const int echoPin = 10;

    long duration;
    int distance;

    void setup() 
    {
          pinMode(13,OUTPUT); 
          pinMode(8,INPUT); 
          pinMode(trigPin, OUTPUT); 
          pinMode(echoPin, INPUT); 
          //pinMode(rainPin, INPUT);
          pinMode(buzzPin,OUTPUT);
          Serial.begin(9600); 
    }
    
    void loop() 
    {
        val = digitalRead(8);    
        if(val == LOW) 
        {
        digitalWrite(13,HIGH); 
        digitalWrite(buzzPin,LOW);
        }
        else
        {
        digitalWrite(13,LOW);
        digitalWrite(buzzPin,HIGH); 
        }
        delay(400); 
        
       digitalWrite(trigPin, LOW);
        delayMicroseconds(2);
        
        digitalWrite(trigPin, HIGH);
        delayMicroseconds(10);
        digitalWrite(trigPin, LOW);
        
        duration = pulseIn(echoPin, HIGH);


        int centimeters = duration/58.2;//cms
        int inches = duration/148;//inchs
        int feet = inches/12;
        int metre = centimeters/100;
   // display on lcd
   
         String cm = String(centimeters);//cms
         String in = String(inches);//inchs
        
        //distance= duration*0.034/2;
        
       // Serial.print("Distance: ");
        Serial.println(feet);
        delay(1000);
                
        //int sensorValue = analogRead(rainPin);
        //delay(1000);
        
        /*if(sensorValue <= 400)
        {
            Serial.println(sensorValue);
            digitalWrite(buzzPin,LOW);
        }
        else if(sensorValue >= 500)
        {
            Serial.println(sensorValue);
            digitalWrite(buzzPin,HIGH);
        }
        else
        {
             Serial.println(sensorValue);
             digitalWrite(buzzPin,LOW);
        }*/
        
    }
