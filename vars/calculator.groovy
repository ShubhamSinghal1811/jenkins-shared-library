def call(var1,var2,ch){
    if (${ch} == "+"){
       sh "res=`echo $var1 + $var2 | bc`"
       sh "echo "reault : $res""
    }
}