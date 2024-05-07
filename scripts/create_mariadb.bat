mkdir data
docker run --name mariadb-lts -v ./data:/var/lib/mysql:Z -p 3306:3306 --env MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=1 mariadb:lts