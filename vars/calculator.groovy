def call(){
    if (${ch} == "+"){
       sh "res=`echo ${var1} + ${var2} | bc`"
       sh "echo $res"
    }
}