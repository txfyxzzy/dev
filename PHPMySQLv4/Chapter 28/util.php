<?php
/** 
 * utf-8 转unicode 
 * 
 * @param string $name 
 * @return string 
 */  
function utf8_unicode($name){  
    $name = iconv('UTF-8', 'UCS-2', $name);  
    $len  = strlen($name);  
    $str  = '';  
    for ($i = 0; $i < $len - 1; $i = $i + 2){  
        $c  = $name[$i];  
        $c2 = $name[$i + 1];  
        if (ord($c) > 0){   //两个字节的文字  
            $str .= '\u'.base_convert(ord($c), 10, 16).str_pad(base_convert(ord($c2), 10, 16), 2, 0, STR_PAD_LEFT);  
            //$str .= base_convert(ord($c), 10, 16).str_pad(base_convert(ord($c2), 10, 16), 2, 0, STR_PAD_LEFT);  
        } else {  
            $str .= '\u'.str_pad(base_convert(ord($c2), 10, 16), 4, 0, STR_PAD_LEFT);  
            //$str .= str_pad(base_convert(ord($c2), 10, 16), 4, 0, STR_PAD_LEFT);  
        }  
    }  
    $str = strtoupper($str);//转换为大写  
    return $str;  
}  

/** 
 * unicode 转 utf-8 
 * 
 * @param string $name 
 * @return string 
 */  
function unicode_decode_a($name)  
{  
    $name = strtolower($name);  
    // 转换编码，将Unicode编码转换成可以浏览的utf-8编码  
    $pattern = '/([\w]+)|(\\\u([\w]{4}))/i';  
    preg_match_all($pattern, $name, $matches);  
    if (!empty($matches))  
    {  
        $name = '';  
        for ($j = 0; $j < count($matches[0]); $j++)  
        {  
            $str = $matches[0][$j];  
            if (strpos($str, '\\u') === 0)  
            {  
                $code = base_convert(substr($str, 2, 2), 16, 10);  
                $code2 = base_convert(substr($str, 4), 16, 10);  
                $c = chr($code).chr($code2);  
                $c = iconv('UCS-2', 'UTF-8', $c);  
                $name .= $c;  
            }  
            else  
            {  
                $name .= $str;  
            }  
        }  
    }  
    return $name;  
}

//将内容进行UNICODE编码，编码后的内容格式：YOKA\u738b （原始：YOKA王）
function unicode_encode($name)
{
    $name = iconv('UTF-8', 'UCS-2', $name);
    $len = strlen($name);
    $str = '';
    for ($i = 0; $i < $len - 1; $i = $i + 2)
    {
        $c = $name[$i];
        $c2 = $name[$i + 1];
        if (ord($c) > 0)
        {    // 两个字节的文字
            $str .= '\u'.base_convert(ord($c), 10, 16).base_convert(ord($c2), 10, 16);
        }
        else
        {
            $str .= $c2;
        }
    }
    return $str;
}

// 将UNICODE编码后的内容进行解码，编码后的内容格式：YOKA\u738b （原始：YOKA王）
function unicode_decode($name)
{
    // 转换编码，将Unicode编码转换成可以浏览的utf-8编码
    $pattern = '/([\w]+)|(\\\u([\w]{4}))/i';
    preg_match_all($pattern, $name, $matches);
    if (!empty($matches))
    {
        $name = '';
        for ($j = 0; $j < count($matches[0]); $j++)
        {
            $str = $matches[0][$j];
            if (strpos($str, '\\u') === 0)
            {
                $code = base_convert(substr($str, 2, 2), 16, 10);
                $code2 = base_convert(substr($str, 4), 16, 10);
                $c = chr($code).chr($code2);
                $c = iconv('UCS-2', 'UTF-8', $c);
                $name .= $c;
            }
            else
            {
                $name .= $str;
            }
        }
    }
    return $name;
}

$name = 'YOKA王';
echo '<h3>'.unicode_encode($name).'</h3>';
echo utf8_unicode($name);
echo '<h3>YOKA\u8b73 -> '.unicode_decode('YOKA\u8b73').'</h3>';

?>