def call(var1,var2,ch){
    if (${ch} == "+"){
        res=`echo $var1 + $var2 | bc`
        echo "reault : $res"
    }
}