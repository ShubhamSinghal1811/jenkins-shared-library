import hudson.model.*
def call(var1,var2,ch){
    if (ch == "+"){
    //    sh "res=`echo ${var1} + ${var2} | bc`"
    //    sh "echo $res"
    sh "echo ${var1} + ${var2} | bc"
    }
    else if (ch == "-"){
        sh "echo ${var1} - ${var2} | bc"
    }
    else if (ch == "*"){
        sh "echo ${var1} * ${var2} | bc"
    }
    else{
        sh "echo ${var1} / ${var2} | bc"
    }
    // sh "echo ${var1} + ${var2} | bc"
    //sh "echo ${res}"
}