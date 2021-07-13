node{
stage( "git"){
git branch: 'branch1', url: 'git@github.com:swetha8998/webhookCreation.git'
}
stage( "build" ){
sh 'echo "in building stage"'
sh 'echo "hi" '
}
stage ( "approve"){
sh 'echo "in approval stage" '
  timeout(time: 15, unit: "MINUTES") {
    input message: 'Do you want to approve the deploy in production?', ok: 'Yes'
}
}
stage ( " deploy "){
sh 'echo "in deployement stage"'

}
}
