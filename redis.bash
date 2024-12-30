#!/bin/bash

# Ensure the script is run with sudo privileges
if [ "$EUID" -ne 0 ]; then
  echo "Please run as root (use sudo)"
  exit 1
fi

# Update package list and install required dependencies
apt-get update && apt-get install -y lsb-release curl gpg

# Add Redis GPG key and save it securely
curl -fsSL https://packages.redis.io/gpg | gpg --dearmor -o /usr/share/keyrings/redis-archive-keyring.gpg
chmod 644 /usr/share/keyrings/redis-archive-keyring.gpg

# Add Redis repository to APT sources
RELEASE=$(lsb_release -cs)
echo "deb [signed-by=/usr/share/keyrings/redis-archive-keyring.gpg] https://packages.redis.io/deb $RELEASE main" | tee /etc/apt/sources.list.d/redis.list

# Update package list and install Redis
apt-get update && apt-get install -y redis

# Enable and start Redis service
systemctl enable redis-server
systemctl start redis-server

# Verify Redis installation
if command -v redis-server > /dev/null; then
  echo "Redis has been successfully installed."
else
  echo "Redis installation failed."
fi
