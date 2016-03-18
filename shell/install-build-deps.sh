#!/bin/bash -e

if ! uname -m | egrep -q "i686|x86_64"; then
  echo "Only x86 architectures are supported." >&2
  exit -1
fi

if [ "x$(id -u)" != x0 ]; then
  echo "Script must be executed as root." >&2
  exit -1
fi

if ! apt-get --version >& /dev/null; then
  echo "You need apt-get to run this script." >&2
  exit -1
fi

# Run the regular build deps script.
CURRDIR=$( cd "$( dirname "$0" )" && pwd )
${CURRDIR}/../../../chromium/src/build/install-build-deps.sh

apt-get update

# Fix deps.
apt-get -f install

# Install deps.
apt-get -y install python-pexpect ant xvfb x11-utils g++-multilib ia32-libs

# Install openjdk.
apt-get -y install openjdk-6-jdk

echo "Build dependencies were successfully installed."
