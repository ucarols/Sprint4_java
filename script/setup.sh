#!/bin/bash


LOCATION="brazilsouth"
RG="rg-s4-motuswatch"
ACR_NAME="motuswatchs4acr"
APP_SERVICE_PLAN="plan-s4-motuswatch"
WEBAPP_NAME="motuswatchs4webapp"
USERNAME="RM559123"
PASSWORD="fiap"

# RODAR MANUALMENTE

# git clone https://github.com/ucarols/Sprint4_java.git

# mv Sprint4_java/script/setup.sh .

# chmod +x setup.sh

# ./setup.sh

az group create --name $RG --location $LOCATION

az appservice plan create \
  --name $APP_SERVICE_PLAN \
  --resource-group $RG \
  --location $LOCATION \
  --sku F1 \
  --is-linux

az webapp create \
  --name $WEBAPP_NAME \
  --resource-group $RG \
  --plan $APP_SERVICE_PLAN \
  --runtime "JAVA:17-java17"

az webapp config appsettings set \
  --name "$WEBAPP_NAME" \
  --resource-group "$RG" \
  --settings \
    WEBSITES_PORT=8080 \
    ACTIVE_PROFILE=prod \
    DB_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL" \
    DB_USERNAME=$USERNAME \
    DB_PASSWORD="$PASSWORD"

cd Sprint4_java/

mvn clean package -DskipTests

## RODAR MANUALMENTE

#cd Sprint4_java/

#az webapp deploy -g rg-s4-motuswatch -n motuswatchs4webapp --src-path ./target/moto-api-0.0.1-SNAPSHOT.jar --type jar

#az webapp log tail -g rg-s4-motuswatch -n motuswatchs4webapp