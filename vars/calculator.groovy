def call(var1,var2,ch){
    if (ch == "+"){
       sh "res=`echo ${var1} + ${var2} | bc`"
       sh "echo $res"
    }
    // sh "res=`echo ${var1} ${ch} ${var2} | bc`"
}