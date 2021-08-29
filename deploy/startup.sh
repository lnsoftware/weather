registry_user=$1
registry_pass=$2
$image_name=weather

ssh $node_user@$node1 "docker login --username=$registry_user --password=$registry_pass"
ssh $node_user@$node1 "docker pull $image_name && docker rm -f $image_name || true "
ssh $node_user@$node1 "docker run -itd --name=$image_name --restart=always  --net=host  -e TZ="Asia/Shanghai" $image_name"