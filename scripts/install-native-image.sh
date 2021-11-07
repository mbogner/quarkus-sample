#!/bin/bash
if [ -n "${GRAALVM_HOME}" ]; then
  cd "${GRAALVM_HOME}" || exit 2
  bin/gu install native-image
else
  echo "GRAALVM_HOME not set"
  exit 1
fi
