node{
stage( "git"){
git branch: 'branch1', url: 'https://github.com/swetha8998/scripted_pipeline.git'
}
stage( "build" ){
sh 'echo "in building stage"'
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
