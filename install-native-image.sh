#!/bin/bash
cd "${GRAALVM_HOME}" || exit 1
bin/gu install native-image
