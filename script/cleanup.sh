#!/bin/bash

# RODAR MANUALEMENTE

# mv ./script/cleanup.sh .

# chmod +x cleanup.sh

# ./cleanup.sh

RG="rg-s4-motuswatch"

az group delete -g $RG --yes --no-wait