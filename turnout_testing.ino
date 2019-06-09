int state;
int turnout;

void setup() {
  // put your setup code here, to run once:
  pinMode(10, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available() > 0) {
    if(Serial.peek() == 'c') {
      Serial.read();
      turnout = Serial.parseInt();
      state = Serial.parseInt();
      if(turnout == 1) {
        if(state == 1) {
          digitalWrite(10, HIGH);
          delay(100);
          digitalWrite(10, LOW);
        }
        else if(state == 0) {
          digitalWrite(10, HIGH);
          delay(100);
          digitalWrite(10,LOW);
          delay(100);
          digitalWrite(10,HIGH);
          delay(100);
          digitalWrite(10,LOW);
        }
      }
    }
    while(Serial.available() > 0) {
      Serial.read();
    }
  }
}
