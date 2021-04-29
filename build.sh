#!/bin/sh

# Build the base container with a tag so it isn't removed when pruning
docker build -t gaggle-base --target base .
docker build -t gaggle .