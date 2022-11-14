def call(){
    case $ch in 
        "+")res=`echo $var1 + $var2 | bc`
        ;;
        "-")res=`echo $var1 - $var2 | bc`
        ;;
        "*")res=`echo $var1 \* $var2 | bc`
        ;;
        "/")res=`echo $var1 / $var2 | bc`
        ;;
}