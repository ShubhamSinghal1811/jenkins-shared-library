case $ch in
  1)res=`echo $var1 + $var2 | bc`
  ;;
  2)res=`echo $var1 - $var2 | bc`
  ;;
  3)res=`echo $var1 \* $var2 | bc`
  ;;
  4)res=`echo "scale=2; $var1 / $var2" | bc`
  ;;
esac
echo "Result : $res"