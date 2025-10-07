# Step 1: Install / Download Kafka

## Option A: Using Docker

Create a file named docker-compose.yml in any folder:

version: '3.8'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.4.0
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - "2181:2181"

  kafka:
    image: confluentinc/cp-kafka:7.4.0
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1


Then open a terminal in that folder and run:
docker-compose up -d


### This starts:

Zookeeper on port 2181
Kafka broker on port 9092

You can check if it's running with:
docker ps

## Option B: Without Docker (manual download)

Download Kafka from https://kafka.apache.org/downloads

Extract the zip/tar file.
Open two terminals inside Kafka folder:

#### Terminal 1 – Start Zookeeper

bin/zookeeper-server-start.sh config/zookeeper.properties   # Linux/Mac
bin\windows\zookeeper-server-start.bat config\zookeeper.properties  # Windows


#### Terminal 2 – Start Kafka Broker

bin/kafka-server-start.sh config/server.properties   # Linux/Mac
bin\windows\kafka-server-start.bat config\server.properties  # Windows


#### Kafka should now run on localhost:9092.

### Step 2: Test Kafka locally
Create a topic:
bin/kafka-topics.sh --create --topic realtime-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

List topics:
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

### Step 3: Produce & Consume messages manually

#### Producer (send messages)

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic realtime-topic
Type some messages and press Enter.

#### Consumer (read messages)
Open a second terminal:

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic realtime-topic --from-beginning

You’ll see the messages in real-time