#!/bin/bash

# 定义Maven构建命令
MAVEN_COMMAND="mvn clean install -Dmaven.test.skip=true"

# 定义包含目录名称的数组
DIRS=("./" )

# 检查Maven是否安装
if ! command -v mvn &> /dev/null
then
    echo "Maven could not be found, please install Maven first."
    exit 1
fi

# 遍历目录数组并执行Maven构建命令
for DIR in "${DIRS[@]}"
do
    # 检查目录是否存在
    if [ ! -d "$DIR" ]; then
        echo "Directory $DIR does not exist. Skipping..."
        continue
    fi

    echo "Building project in directory $DIR..."
    cd "$DIR" || { echo "Failed to change directory to $DIR."; exit 1; }
    $MAVEN_COMMAND || { echo "Maven build failed in directory $DIR."; exit 1; }
    cd - > /dev/null # 返回上一级目录
done

echo "All builds completed successfully."
