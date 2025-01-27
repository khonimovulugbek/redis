# Installation Redis On Ubuntu
- copy redis.bash file to your ubuntu server
- write command `bash redis.bash` 
- check redis status with command `systemctl status redis-server`
``` 
redis-server.service - Advanced key-value store
     Loaded: loaded (/lib/systemd/system/redis-server.service; enabled; vendor preset: enabled)
     Active: active (running) since Mon 2024-12-30 08:34:45 CET; 3min 31s ago
       Docs: http://redis.io/documentation,
             man:redis-server(1)
   Main PID: 50062 (redis-server)
     Status: "Ready to accept connections"
      Tasks: 6 (limit: 7036)
     Memory: 3.9M
        CPU: 1.041s
     CGroup: /system.slice/redis-server.service
             └─50062 "/usr/bin/redis-server 127.0.0.1:6379" "" "" "" "" "" "" ""
           
```

# Allow External Connections
- change configuration with command `sudo nano /etc/redis/redis.conf`
- Look for the line: `bind 127.0.0.1`
- Change it to: `bind 0.0.0.0`

# Password for Redis:
- Open the Redis configuration file: `sudo nano /etc/redis/redis.conf`
- Find the requirepass Directive: Look for the line: `# requirepass foobared`
- Uncomment it and replace foobared with your desired password: `requirepass your_secure_password`
- Restart Redis: Save the file and restart Redis to apply the changes: `sudo systemctl restart redis-server`

# Connecting with a Password:
- When connecting to Redis after setting a password, you need to authenticate using the AUTH command in the Redis CLI:
```
redis-cli
127.0.0.1:6379> AUTH your_secure_password
OK
```