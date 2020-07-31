<template>
  <b-container fluid>
    <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">X</label>
    </b-col>
    <b-col sm="3">
      <b-form-input size="sm" v-model="objectX" v-on:keyup="moveXObject"> </b-form-input>
    </b-col>
     <b-col sm="3">
       <label for="input-small">Y</label>
    </b-col>
    <b-col sm="3">
      <b-form-input size="sm" v-model="objectY" v-on:keyup="moveYObject"></b-form-input>
    </b-col>
    </b-row>
    <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">fontsize</label>
     </b-col>
     <b-col sm="3">
      <b-form-input size="sm" v-model="objectFontSize"  v-on:keyup="resizeTextBox"></b-form-input>
     </b-col>
     <b-col sm="3">
       <label for="input-small">fontWeight</label>
     </b-col>
     <b-col sm="3">
      <b-form-checkbox id="checkbox-1" v-model="objectBold" name="checkbox-1" value="bold"  unchecked-value="" @change="boldChk($event)">
      BOLD
      </b-form-checkbox>
     </b-col>
    </b-row>
    <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">fontStyle</label>
     </b-col>
      <b-col sm="4">
        <b-form-radio v-model="objectStyle"  value="normal"  @change="styleChk($event)" checked>
        normal
        </b-form-radio>
      </b-col>
      <b-col sm="4">
        <b-form-radio v-model="objectStyle"  value="italic"  @change="styleChk($event)">
        italic
        </b-form-radio>
      </b-col>
    </b-row>
    <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">font</label>
    </b-col>
    <b-col sm="9">
      <b-form-select  v-model="objectFont" class="mb-3" v-on:change="onChange($event)" >
        <b-form-select-option value="" selected></b-form-select-option>
<!--         <b-form-select-option value="M PLUS 1p, sans-serif" style="font-family: 'M PLUS 1p', sans-serif;">M PLUS 1p</b-form-select-option>
        <b-form-select-option value="M PLUS Rounded 1c, sans-serif" style="font-family: 'M PLUS Rounded 1c', sans-serif;">M PLUS Rounded 1c</b-form-select-option> -->
        <b-form-select-option value="Kosugi, sans-serif" style="font-family: 'Kosugi', sans-serif;">Kosugi</b-form-select-option>
        <b-form-select-option value="Kosugi Maru, sans-serif" style="font-family: 'Kosugi Maru', sans-serif;">Kosugi Maru</b-form-select-option>
        <b-form-select-option value="Noto Sans, sans-serif" style="font-family: 'Noto Sans JP', sans-serif;">Noto Sans JP</b-form-select-option>
        <b-form-select-option value="Noto Serif JP, serif" style="font-family: 'Noto Serif JP', serif;">Noto Serif JP</b-form-select-option>
        <b-form-select-option value="Sawarabi Mincho, sans-serif" style="font-family: 'Sawarabi Mincho', sans-serif;">Sawarabi Mincho</b-form-select-option>
        <b-form-select-option value="Sawarabi Gothic, sans-serif" style="font-family: 'Sawarabi Gothic', sans-serif;">Sawarabi Gothic</b-form-select-option>
      </b-form-select>
    </b-col>
    </b-row>
    <b-row class="my-1">
    <b-col sm="3">
       <label for="input-small">color</label>
    </b-col>
    <b-col sm="3">
      <input type="color" v-model="objectColor" value=""  v-on:change="clickColor()" style="width:85%;">
    </b-col>
    </b-row>
    <!-- Color picker -->
    <!-- <b-row class="my-1">
    <b-col sm="9">
    <img style='margin-right:2px;' src='https://www.w3schools.com/colors/img_colormap.gif' usemap='#colormap' alt='colormap' />
    <map id='colormap' name='colormap' v-on:mouseout='mouseOutMap()' >
      <area style='cursor:pointer' shape='poly' coords='63,0,72,4,72,15,63,19,54,15,54,4' v-on:click='clickColorHex("#003366",-200,54)'  v-on:mouseover ='mouseOverColor("#003366")' alt='#003366' />
      <area style='cursor:pointer' shape='poly' coords='81,0,90,4,90,15,81,19,72,15,72,4' v-on:click='clickColorHex("#336699",-200,72)' v-on:mouseover ='mouseOverColor("#336699")' alt='#336699' />
      <area style='cursor:pointer' shape='poly' coords='99,0,108,4,108,15,99,19,90,15,90,4' v-on:click='clickColorHex("#3366CC",-200,90)' v-on:mouseover ='mouseOverColor("#3366CC")' alt='#3366CC' />
      <area style='cursor:pointer' shape='poly' coords='117,0,126,4,126,15,117,19,108,15,108,4' v-on:click='clickColorHex("#003399",-200,108)' v-on:mouseover ='mouseOverColor("#003399")' alt='#003399' />
      <area style='cursor:pointer' shape='poly' coords='135,0,144,4,144,15,135,19,126,15,126,4' v-on:click='clickColorHex("#000099",-200,126)' v-on:mouseover ='mouseOverColor("#000099")' alt='#000099' />
      <area style='cursor:pointer' shape='poly' coords='153,0,162,4,162,15,153,19,144,15,144,4' v-on:click='clickColorHex("#0000CC",-200,144)' v-on:mouseover ='mouseOverColor("#0000CC")' alt='#0000CC' />
      <area style='cursor:pointer' shape='poly' coords='171,0,180,4,180,15,171,19,162,15,162,4' v-on:click='clickColorHex("#000066",-200,162)' v-on:mouseover ='mouseOverColor("#000066")' alt='#000066' />
      <area style='cursor:pointer' shape='poly' coords='54,15,63,19,63,30,54,34,45,30,45,19' v-on:click='clickColorHex("#006666",-185,45)' v-on:mouseover ='mouseOverColor("#006666")' alt='#006666' />
      <area style='cursor:pointer' shape='poly' coords='72,15,81,19,81,30,72,34,63,30,63,19' v-on:click='clickColorHex("#006699",-185,63)' v-on:mouseover ='mouseOverColor("#006699")' alt='#006699' />
      <area style='cursor:pointer' shape='poly' coords='90,15,99,19,99,30,90,34,81,30,81,19' v-on:click='clickColorHex("#0099CC",-185,81)' v-on:mouseover ='mouseOverColor("#0099CC")' alt='#0099CC' />
      <area style='cursor:pointer' shape='poly' coords='108,15,117,19,117,30,108,34,99,30,99,19' v-on:click='clickColorHex("#0066CC",-185,99)' v-on:mouseover ='mouseOverColor("#0066CC")' alt='#0066CC' />
      <area style='cursor:pointer' shape='poly' coords='126,15,135,19,135,30,126,34,117,30,117,19' v-on:click='clickColorHex("#0033CC",-185,117)' v-on:mouseover ='mouseOverColor("#0033CC")' alt='#0033CC' />
      <area style='cursor:pointer' shape='poly' coords='144,15,153,19,153,30,144,34,135,30,135,19' v-on:click='clickColorHex("#0000FF",-185,135)' v-on:mouseover ='mouseOverColor("#0000FF")' alt='#0000FF' />
      <area style='cursor:pointer' shape='poly' coords='162,15,171,19,171,30,162,34,153,30,153,19' v-on:click='clickColorHex("#3333FF",-185,153)' v-on:mouseover ='mouseOverColor("#3333FF")' alt='#3333FF' />
      <area style='cursor:pointer' shape='poly' coords='180,15,189,19,189,30,180,34,171,30,171,19' v-on:click='clickColorHex("#333399",-185,171)' v-on:mouseover ='mouseOverColor("#333399")' alt='#333399' />
      <area style='cursor:pointer' shape='poly' coords='45,30,54,34,54,45,45,49,36,45,36,34' v-on:click='clickColorHex("#669999",-170,36)' v-on:mouseover ='mouseOverColor("#669999")' alt='#669999' />
      <area style='cursor:pointer' shape='poly' coords='63,30,72,34,72,45,63,49,54,45,54,34' v-on:click='clickColorHex("#009999",-170,54)' v-on:mouseover ='mouseOverColor("#009999")' alt='#009999' />
      <area style='cursor:pointer' shape='poly' coords='81,30,90,34,90,45,81,49,72,45,72,34' v-on:click='clickColorHex("#33CCCC",-170,72)' v-on:mouseover ='mouseOverColor("#33CCCC")' alt='#33CCCC' />
      <area style='cursor:pointer' shape='poly' coords='99,30,108,34,108,45,99,49,90,45,90,34' v-on:click='clickColorHex("#00CCFF",-170,90)' v-on:mouseover ='mouseOverColor("#00CCFF")' alt='#00CCFF' />
      <area style='cursor:pointer' shape='poly' coords='117,30,126,34,126,45,117,49,108,45,108,34' v-on:click='clickColorHex("#0099FF",-170,108)' v-on:mouseover ='mouseOverColor("#0099FF")' alt='#0099FF' />
      <area style='cursor:pointer' shape='poly' coords='135,30,144,34,144,45,135,49,126,45,126,34' v-on:click='clickColorHex("#0066FF",-170,126)' v-on:mouseover ='mouseOverColor("#0066FF")' alt='#0066FF' />
      <area style='cursor:pointer' shape='poly' coords='153,30,162,34,162,45,153,49,144,45,144,34' v-on:click='clickColorHex("#3366FF",-170,144)' v-on:mouseover ='mouseOverColor("#3366FF")' alt='#3366FF' />
      <area style='cursor:pointer' shape='poly' coords='171,30,180,34,180,45,171,49,162,45,162,34' v-on:click='clickColorHex("#3333CC",-170,162)' v-on:mouseover ='mouseOverColor("#3333CC")' alt='#3333CC' />
      <area style='cursor:pointer' shape='poly' coords='189,30,198,34,198,45,189,49,180,45,180,34' v-on:click='clickColorHex("#666699",-170,180)' v-on:mouseover ='mouseOverColor("#666699")' alt='#666699' />
      <area style='cursor:pointer' shape='poly' coords='36,45,45,49,45,60,36,64,27,60,27,49' v-on:click='clickColorHex("#339966",-155,27)' v-on:mouseover ='mouseOverColor("#339966")' alt='#339966' />
      <area style='cursor:pointer' shape='poly' coords='54,45,63,49,63,60,54,64,45,60,45,49' v-on:click='clickColorHex("#00CC99",-155,45)' v-on:mouseover ='mouseOverColor("#00CC99")' alt='#00CC99' />
      <area style='cursor:pointer' shape='poly' coords='72,45,81,49,81,60,72,64,63,60,63,49' v-on:click='clickColorHex("#00FFCC",-155,63)' v-on:mouseover ='mouseOverColor("#00FFCC")' alt='#00FFCC' />
      <area style='cursor:pointer' shape='poly' coords='90,45,99,49,99,60,90,64,81,60,81,49' v-on:click='clickColorHex("#00FFFF",-155,81)' v-on:mouseover ='mouseOverColor("#00FFFF")' alt='#00FFFF' />
      <area style='cursor:pointer' shape='poly' coords='108,45,117,49,117,60,108,64,99,60,99,49' v-on:click='clickColorHex("#33CCFF",-155,99)' v-on:mouseover ='mouseOverColor("#33CCFF")' alt='#33CCFF' />
      <area style='cursor:pointer' shape='poly' coords='126,45,135,49,135,60,126,64,117,60,117,49' v-on:click='clickColorHex("#3399FF",-155,117)' v-on:mouseover ='mouseOverColor("#3399FF")' alt='#3399FF' />
      <area style='cursor:pointer' shape='poly' coords='144,45,153,49,153,60,144,64,135,60,135,49' v-on:click='clickColorHex("#6699FF",-155,135)' v-on:mouseover ='mouseOverColor("#6699FF")' alt='#6699FF' />
      <area style='cursor:pointer' shape='poly' coords='162,45,171,49,171,60,162,64,153,60,153,49' v-on:click='clickColorHex("#6666FF",-155,153)' v-on:mouseover ='mouseOverColor("#6666FF")' alt='#6666FF' />
      <area style='cursor:pointer' shape='poly' coords='180,45,189,49,189,60,180,64,171,60,171,49' v-on:click='clickColorHex("#6600FF",-155,171)' v-on:mouseover ='mouseOverColor("#6600FF")' alt='#6600FF' />
      <area style='cursor:pointer' shape='poly' coords='198,45,207,49,207,60,198,64,189,60,189,49' v-on:click='clickColorHex("#6600CC",-155,189)' v-on:mouseover ='mouseOverColor("#6600CC")' alt='#6600CC' />
      <area style='cursor:pointer' shape='poly' coords='27,60,36,64,36,75,27,79,18,75,18,64' v-on:click='clickColorHex("#339933",-140,18)' v-on:mouseover ='mouseOverColor("#339933")' alt='#339933' />
      <area style='cursor:pointer' shape='poly' coords='45,60,54,64,54,75,45,79,36,75,36,64' v-on:click='clickColorHex("#00CC66",-140,36)' v-on:mouseover ='mouseOverColor("#00CC66")' alt='#00CC66' />
      <area style='cursor:pointer' shape='poly' coords='63,60,72,64,72,75,63,79,54,75,54,64' v-on:click='clickColorHex("#00FF99",-140,54)' v-on:mouseover ='mouseOverColor("#00FF99")' alt='#00FF99' />
      <area style='cursor:pointer' shape='poly' coords='81,60,90,64,90,75,81,79,72,75,72,64' v-on:click='clickColorHex("#66FFCC",-140,72)' v-on:mouseover ='mouseOverColor("#66FFCC")' alt='#66FFCC' />
      <area style='cursor:pointer' shape='poly' coords='99,60,108,64,108,75,99,79,90,75,90,64' v-on:click='clickColorHex("#66FFFF",-140,90)' v-on:mouseover ='mouseOverColor("#66FFFF")' alt='#66FFFF' />
      <area style='cursor:pointer' shape='poly' coords='117,60,126,64,126,75,117,79,108,75,108,64' v-on:click='clickColorHex("#66CCFF",-140,108)' v-on:mouseover ='mouseOverColor("#66CCFF")' alt='#66CCFF' />
      <area style='cursor:pointer' shape='poly' coords='135,60,144,64,144,75,135,79,126,75,126,64' v-on:click='clickColorHex("#99CCFF",-140,126)' v-on:mouseover ='mouseOverColor("#99CCFF")' alt='#99CCFF' />
      <area style='cursor:pointer' shape='poly' coords='153,60,162,64,162,75,153,79,144,75,144,64' v-on:click='clickColorHex("#9999FF",-140,144)' v-on:mouseover ='mouseOverColor("#9999FF")' alt='#9999FF' />
      <area style='cursor:pointer' shape='poly' coords='171,60,180,64,180,75,171,79,162,75,162,64' v-on:click='clickColorHex("#9966FF",-140,162)' v-on:mouseover ='mouseOverColor("#9966FF")' alt='#9966FF' />
      <area style='cursor:pointer' shape='poly' coords='189,60,198,64,198,75,189,79,180,75,180,64' v-on:click='clickColorHex("#9933FF",-140,180)' v-on:mouseover ='mouseOverColor("#9933FF")' alt='#9933FF' />
      <area style='cursor:pointer' shape='poly' coords='207,60,216,64,216,75,207,79,198,75,198,64' v-on:click='clickColorHex("#9900FF",-140,198)' v-on:mouseover ='mouseOverColor("#9900FF")' alt='#9900FF' />
      <area style='cursor:pointer' shape='poly' coords='18,75,27,79,27,90,18,94,9,90,9,79' v-on:click='clickColorHex("#006600",-125,9)' v-on:mouseover ='mouseOverColor("#006600")' alt='#006600' />
      <area style='cursor:pointer' shape='poly' coords='36,75,45,79,45,90,36,94,27,90,27,79' v-on:click='clickColorHex("#00CC00",-125,27)' v-on:mouseover ='mouseOverColor("#00CC00")' alt='#00CC00' />
      <area style='cursor:pointer' shape='poly' coords='54,75,63,79,63,90,54,94,45,90,45,79' v-on:click='clickColorHex("#00FF00",-125,45)' v-on:mouseover ='mouseOverColor("#00FF00")' alt='#00FF00' />
      <area style='cursor:pointer' shape='poly' coords='72,75,81,79,81,90,72,94,63,90,63,79' v-on:click='clickColorHex("#66FF99",-125,63)' v-on:mouseover ='mouseOverColor("#66FF99")' alt='#66FF99' />
      <area style='cursor:pointer' shape='poly' coords='90,75,99,79,99,90,90,94,81,90,81,79' v-on:click='clickColorHex("#99FFCC",-125,81)' v-on:mouseover ='mouseOverColor("#99FFCC")' alt='#99FFCC' />
      <area style='cursor:pointer' shape='poly' coords='108,75,117,79,117,90,108,94,99,90,99,79' v-on:click='clickColorHex("#CCFFFF",-125,99)' v-on:mouseover ='mouseOverColor("#CCFFFF")' alt='#CCFFFF' />
      <area style='cursor:pointer' shape='poly' coords='126,75,135,79,135,90,126,94,117,90,117,79' v-on:click='clickColorHex("#CCCCFF",-125,117)' v-on:mouseover ='mouseOverColor("#CCCCFF")' alt='#CCCCFF' />
      <area style='cursor:pointer' shape='poly' coords='144,75,153,79,153,90,144,94,135,90,135,79' v-on:click='clickColorHex("#CC99FF",-125,135)'  v-on:mouseover ='mouseOverColor("#CC99FF")' alt='#CC99FF' />
      <area style='cursor:pointer' shape='poly' coords='162,75,171,79,171,90,162,94,153,90,153,79' v-on:click='clickColorHex("#CC66FF",-125,153)' v-on:mouseover ='mouseOverColor("#CC66FF")' alt='#CC66FF' />
      <area style='cursor:pointer' shape='poly' coords='180,75,189,79,189,90,180,94,171,90,171,79' v-on:click='clickColorHex("#CC33FF",-125,171)' v-on:mouseover ='mouseOverColor("#CC33FF")' alt='#CC33FF' />
      <area style='cursor:pointer' shape='poly' coords='198,75,207,79,207,90,198,94,189,90,189,79' v-on:click='clickColorHex("#CC00FF",-125,189)' v-on:mouseover ='mouseOverColor("#CC00FF")' alt='#CC00FF' />
      <area style='cursor:pointer' shape='poly' coords='216,75,225,79,225,90,216,94,207,90,207,79' v-on:click='clickColorHex("#9900CC",-125,207)' v-on:mouseover ='mouseOverColor("#9900CC")' alt='#9900CC' />
      <area style='cursor:pointer' shape='poly' coords='9,90,18,94,18,105,9,109,0,105,0,94' v-on:click='clickColorHex("#003300",-110,0)' v-on:mouseover ='mouseOverColor("#003300")' alt='#003300' />
      <area style='cursor:pointer' shape='poly' coords='27,90,36,94,36,105,27,109,18,105,18,94' v-on:click='clickColorHex("#009933",-110,18)' v-on:mouseover ='mouseOverColor("#009933")' alt='#009933' />
      <area style='cursor:pointer' shape='poly' coords='45,90,54,94,54,105,45,109,36,105,36,94' v-on:click='clickColorHex("#33CC33",-110,36)' v-on:mouseover ='mouseOverColor("#33CC33")' alt='#33CC33' />
      <area style='cursor:pointer' shape='poly' coords='63,90,72,94,72,105,63,109,54,105,54,94' v-on:click='clickColorHex("#66FF66",-110,54)' v-on:mouseover ='mouseOverColor("#66FF66")' alt='#66FF66' />
      <area style='cursor:pointer' shape='poly' coords='81,90,90,94,90,105,81,109,72,105,72,94' v-on:click='clickColorHex("#99FF99",-110,72)' v-on:mouseover ='mouseOverColor("#99FF99")' alt='#99FF99' />
      <area style='cursor:pointer' shape='poly' coords='99,90,108,94,108,105,99,109,90,105,90,94' v-on:click='clickColorHex("#CCFFCC",-110,90)' v-on:mouseover ='mouseOverColor("#CCFFCC")' alt='#CCFFCC' />
      <area style='cursor:pointer' shape='poly' coords='117,90,126,94,126,105,117,109,108,105,108,94' v-on:click='clickColorHex("#FFFFFF",-110,108)' v-on:mouseover ='mouseOverColor("#FFFFFF")' alt='#FFFFFF' />
      <area style='cursor:pointer' shape='poly' coords='135,90,144,94,144,105,135,109,126,105,126,94' v-on:click='clickColorHex("#FFCCFF",-110,126)' v-on:mouseover ='mouseOverColor("#FFCCFF")' alt='#FFCCFF' />
      <area style='cursor:pointer' shape='poly' coords='153,90,162,94,162,105,153,109,144,105,144,94' v-on:click='clickColorHex("#FF99FF",-110,144)' v-on:mouseover ='mouseOverColor("#FF99FF")' alt='#FF99FF' />
      <area style='cursor:pointer' shape='poly' coords='171,90,180,94,180,105,171,109,162,105,162,94' v-on:click='clickColorHex("#FF66FF",-110,162)' v-on:mouseover ='mouseOverColor("#FF66FF")' alt='#FF66FF' />
      <area style='cursor:pointer' shape='poly' coords='189,90,198,94,198,105,189,109,180,105,180,94' v-on:click='clickColorHex("#FF00FF",-110,180)' v-on:mouseover ='mouseOverColor("#FF00FF")' alt='#FF00FF' />
      <area style='cursor:pointer' shape='poly' coords='207,90,216,94,216,105,207,109,198,105,198,94' v-on:click='clickColorHex("#CC00CC",-110,198)' v-on:mouseover ='mouseOverColor("#CC00CC")' alt='#CC00CC' />
      <area style='cursor:pointer' shape='poly' coords='225,90,234,94,234,105,225,109,216,105,216,94' v-on:click='clickColorHex("#660066",-110,216)' v-on:mouseover ='mouseOverColor("#660066")' alt='#660066' />
      <area style='cursor:pointer' shape='poly' coords='18,105,27,109,27,120,18,124,9,120,9,109' v-on:click='clickColorHex("#336600",-95,9)' v-on:mouseover ='mouseOverColor("#336600")' alt='#336600' />
      <area style='cursor:pointer' shape='poly' coords='36,105,45,109,45,120,36,124,27,120,27,109' v-on:click='clickColorHex("#009900",-95,27)' v-on:mouseover ='mouseOverColor("#009900")' alt='#009900' />
      <area style='cursor:pointer' shape='poly' coords='54,105,63,109,63,120,54,124,45,120,45,109' v-on:click='clickColorHex("#66FF33",-95,45)' v-on:mouseover ='mouseOverColor("#66FF33")' alt='#66FF33' />
      <area style='cursor:pointer' shape='poly' coords='72,105,81,109,81,120,72,124,63,120,63,109' v-on:click='clickColorHex("#99FF66",-95,63)' v-on:mouseover ='mouseOverColor("#99FF66")' alt='#99FF66' />
      <area style='cursor:pointer' shape='poly' coords='90,105,99,109,99,120,90,124,81,120,81,109' v-on:click='clickColorHex("#CCFF99",-95,81)' v-on:mouseover ='mouseOverColor("#CCFF99")' alt='#CCFF99' />
      <area style='cursor:pointer' shape='poly' coords='108,105,117,109,117,120,108,124,99,120,99,109' v-on:click='clickColorHex("#FFFFCC",-95,99)' v-on:mouseover ='mouseOverColor("#FFFFCC")' alt='#FFFFCC' />
      <area style='cursor:pointer' shape='poly' coords='126,105,135,109,135,120,126,124,117,120,117,109' v-on:click='clickColorHex("#FFCCCC",-95,117)' v-on:mouseover ='mouseOverColor("#FFCCCC")' alt='#FFCCCC' />
      <area style='cursor:pointer' shape='poly' coords='144,105,153,109,153,120,144,124,135,120,135,109' v-on:click='clickColorHex("#FF99CC",-95,135)' v-on:mouseover ='mouseOverColor("#FF99CC")' alt='#FF99CC' />
      <area style='cursor:pointer' shape='poly' coords='162,105,171,109,171,120,162,124,153,120,153,109' v-on:click='clickColorHex("#FF66CC",-95,153)' v-on:mouseover ='mouseOverColor("#FF66CC")' alt='#FF66CC' />
      <area style='cursor:pointer' shape='poly' coords='180,105,189,109,189,120,180,124,171,120,171,109' v-on:click='clickColorHex("#FF33CC",-95,171)' v-on:mouseover ='mouseOverColor("#FF33CC")' alt='#FF33CC' />
      <area style='cursor:pointer' shape='poly' coords='198,105,207,109,207,120,198,124,189,120,189,109' v-on:click='clickColorHex("#CC0099",-95,189)' v-on:mouseover ='mouseOverColor("#CC0099")' alt='#CC0099' />
      <area style='cursor:pointer' shape='poly' coords='216,105,225,109,225,120,216,124,207,120,207,109' v-on:click='clickColorHex("#993399",-95,207)' v-on:mouseover ='mouseOverColor("#993399")' alt='#993399' />
      <area style='cursor:pointer' shape='poly' coords='27,120,36,124,36,135,27,139,18,135,18,124' v-on:click='clickColorHex("#333300",-80,18)' v-on:mouseover ='mouseOverColor("#333300")' alt='#333300' />
      <area style='cursor:pointer' shape='poly' coords='45,120,54,124,54,135,45,139,36,135,36,124' v-on:click='clickColorHex("#669900",-80,36)' v-on:mouseover ='mouseOverColor("#669900")' alt='#669900' />
      <area style='cursor:pointer' shape='poly' coords='63,120,72,124,72,135,63,139,54,135,54,124' v-on:click='clickColorHex("#99FF33",-80,54)' v-on:mouseover ='mouseOverColor("#99FF33")' alt='#99FF33' />
      <area style='cursor:pointer' shape='poly' coords='81,120,90,124,90,135,81,139,72,135,72,124' v-on:click='clickColorHex("#CCFF66",-80,72)' v-on:mouseover ='mouseOverColor("#CCFF66")' alt='#CCFF66' />
      <area style='cursor:pointer' shape='poly' coords='99,120,108,124,108,135,99,139,90,135,90,124' v-on:click='clickColorHex("#FFFF99",-80,90)' v-on:mouseover ='mouseOverColor("#FFFF99")' alt='#FFFF99' />
      <area style='cursor:pointer' shape='poly' coords='117,120,126,124,126,135,117,139,108,135,108,124' v-on:click='clickColorHex("#FFCC99",-80,108)' v-on:mouseover ='mouseOverColor("#FFCC99")' alt='#FFCC99' />
      <area style='cursor:pointer' shape='poly' coords='135,120,144,124,144,135,135,139,126,135,126,124' v-on:click='clickColorHex("#FF9999",-80,126)' v-on:mouseover ='mouseOverColor("#FF9999")' alt='#FF9999' />
      <area style='cursor:pointer' shape='poly' coords='153,120,162,124,162,135,153,139,144,135,144,124' v-on:click='clickColorHex("#FF6699",-80,144)' v-on:mouseover ='mouseOverColor("#FF6699")' alt='#FF6699' />
      <area style='cursor:pointer' shape='poly' coords='171,120,180,124,180,135,171,139,162,135,162,124' v-on:click='clickColorHex("#FF3399",-80,162)' v-on:mouseover ='mouseOverColor("#FF3399")' alt='#FF3399' />
      <area style='cursor:pointer' shape='poly' coords='189,120,198,124,198,135,189,139,180,135,180,124' v-on:click='clickColorHex("#CC3399",-80,180)' v-on:mouseover ='mouseOverColor("#CC3399")' alt='#CC3399' />
      <area style='cursor:pointer' shape='poly' coords='207,120,216,124,216,135,207,139,198,135,198,124' v-on:click='clickColorHex("#990099",-80,198)' v-on:mouseover ='mouseOverColor("#990099")' alt='#990099' />
      <area style='cursor:pointer' shape='poly' coords='36,135,45,139,45,150,36,154,27,150,27,139' v-on:click='clickColorHex("#666633",-65,27)' v-on:mouseover ='mouseOverColor("#666633")' alt='#666633' />
      <area style='cursor:pointer' shape='poly' coords='54,135,63,139,63,150,54,154,45,150,45,139' v-on:click='clickColorHex("#99CC00",-65,45)' v-on:mouseover ='mouseOverColor("#99CC00")' alt='#99CC00' />
      <area style='cursor:pointer' shape='poly' coords='72,135,81,139,81,150,72,154,63,150,63,139' v-on:click='clickColorHex("#CCFF33",-65,63)' v-on:mouseover ='mouseOverColor("#CCFF33")' alt='#CCFF33' />
      <area style='cursor:pointer' shape='poly' coords='90,135,99,139,99,150,90,154,81,150,81,139' v-on:click='clickColorHex("#FFFF66",-65,81)' v-on:mouseover ='mouseOverColor("#FFFF66")' alt='#FFFF66' />
      <area style='cursor:pointer' shape='poly' coords='108,135,117,139,117,150,108,154,99,150,99,139' v-on:click='clickColorHex("#FFCC66",-65,99)' v-on:mouseover ='mouseOverColor("#FFCC66")' alt='#FFCC66' />
      <area style='cursor:pointer' shape='poly' coords='126,135,135,139,135,150,126,154,117,150,117,139' v-on:click='clickColorHex("#FF9966",-65,117)' v-on:mouseover ='mouseOverColor("#FF9966")' alt='#FF9966' />
      <area style='cursor:pointer' shape='poly' coords='144,135,153,139,153,150,144,154,135,150,135,139' v-on:click='clickColorHex("#FF6666",-65,135)' v-on:mouseover ='mouseOverColor("#FF6666")' alt='#FF6666' />
      <area style='cursor:pointer' shape='poly' coords='162,135,171,139,171,150,162,154,153,150,153,139' v-on:click='clickColorHex("#FF0066",-65,153)' v-on:mouseover ='mouseOverColor("#FF0066")' alt='#FF0066' />
      <area style='cursor:pointer' shape='poly' coords='180,135,189,139,189,150,180,154,171,150,171,139' v-on:click='clickColorHex("#CC6699",-65,171)' v-on:mouseover ='mouseOverColor("#CC6699")' alt='#CC6699' />
      <area style='cursor:pointer' shape='poly' coords='198,135,207,139,207,150,198,154,189,150,189,139' v-on:click='clickColorHex("#993366",-65,189)' v-on:mouseover ='mouseOverColor("#993366")' alt='#993366' />
      <area style='cursor:pointer' shape='poly' coords='45,150,54,154,54,165,45,169,36,165,36,154' v-on:click='clickColorHex("#999966",-50,36)' v-on:mouseover ='mouseOverColor("#999966")' alt='#999966' />
      <area style='cursor:pointer' shape='poly' coords='63,150,72,154,72,165,63,169,54,165,54,154' v-on:click='clickColorHex("#CCCC00",-50,54)' v-on:mouseover ='mouseOverColor("#CCCC00")' alt='#CCCC00' />
      <area style='cursor:pointer' shape='poly' coords='81,150,90,154,90,165,81,169,72,165,72,154' v-on:click='clickColorHex("#FFFF00",-50,72)' v-on:mouseover ='mouseOverColor("#FFFF00")' alt='#FFFF00' />
      <area style='cursor:pointer' shape='poly' coords='99,150,108,154,108,165,99,169,90,165,90,154' v-on:click='clickColorHex("#FFCC00",-50,90)' v-on:mouseover ='mouseOverColor("#FFCC00")' alt='#FFCC00' />
      <area style='cursor:pointer' shape='poly' coords='117,150,126,154,126,165,117,169,108,165,108,154' v-on:click='clickColorHex("#FF9933",-50,108)' v-on:mouseover ='mouseOverColor("#FF9933")' alt='#FF9933' />
      <area style='cursor:pointer' shape='poly' coords='135,150,144,154,144,165,135,169,126,165,126,154' v-on:click='clickColorHex("#FF6600",-50,126)' v-on:mouseover ='mouseOverColor("#FF6600")' alt='#FF6600' />
      <area style='cursor:pointer' shape='poly' coords='153,150,162,154,162,165,153,169,144,165,144,154' v-on:click='clickColorHex("#FF5050",-50,144)' v-on:mouseover ='mouseOverColor("#FF5050")' alt='#FF5050' />
      <area style='cursor:pointer' shape='poly' coords='171,150,180,154,180,165,171,169,162,165,162,154' v-on:click='clickColorHex("#CC0066",-50,162)' v-on:mouseover ='mouseOverColor("#CC0066")' alt='#CC0066' />
      <area style='cursor:pointer' shape='poly' coords='189,150,198,154,198,165,189,169,180,165,180,154' v-on:click='clickColorHex("#660033",-50,180)' v-on:mouseover ='mouseOverColor("#660033")' alt='#660033' />
      <area style='cursor:pointer' shape='poly' coords='54,165,63,169,63,180,54,184,45,180,45,169' v-on:click='clickColorHex("#996633",-35,45)' v-on:mouseover ='mouseOverColor("#996633")' alt='#996633' />
      <area style='cursor:pointer' shape='poly' coords='72,165,81,169,81,180,72,184,63,180,63,169' v-on:click='clickColorHex("#CC9900",-35,63)' v-on:mouseover ='mouseOverColor("#CC9900")' alt='#CC9900' />
      <area style='cursor:pointer' shape='poly' coords='90,165,99,169,99,180,90,184,81,180,81,169' v-on:click='clickColorHex("#FF9900",-35,81)' v-on:mouseover ='mouseOverColor("#FF9900")' alt='#FF9900' />
      <area style='cursor:pointer' shape='poly' coords='108,165,117,169,117,180,108,184,99,180,99,169' v-on:click='clickColorHex("#CC6600",-35,99)' v-on:mouseover ='mouseOverColor("#CC6600")' alt='#CC6600' />
      <area style='cursor:pointer' shape='poly' coords='126,165,135,169,135,180,126,184,117,180,117,169' v-on:click='clickColorHex("#FF3300",-35,117)' v-on:mouseover ='mouseOverColor("#FF3300")' alt='#FF3300' />
      <area style='cursor:pointer' shape='poly' coords='144,165,153,169,153,180,144,184,135,180,135,169' v-on:click='clickColorHex("#FF0000",-35,135)' v-on:mouseover ='mouseOverColor("#FF0000")' alt='#FF0000' />
      <area style='cursor:pointer' shape='poly' coords='162,165,171,169,171,180,162,184,153,180,153,169' v-on:click='clickColorHex("#CC0000",-35,153)' v-on:mouseover ='mouseOverColor("#CC0000")' alt='#CC0000' />
      <area style='cursor:pointer' shape='poly' coords='180,165,189,169,189,180,180,184,171,180,171,169' v-on:click='clickColorHex("#990033",-35,171)' v-on:mouseover ='mouseOverColor("#990033")' alt='#990033' />
      <area style='cursor:pointer' shape='poly' coords='63,180,72,184,72,195,63,199,54,195,54,184' v-on:click='clickColorHex("#663300",-20,54)' v-on:mouseover ='mouseOverColor("#663300")' alt='#663300' />
      <area style='cursor:pointer' shape='poly' coords='81,180,90,184,90,195,81,199,72,195,72,184' v-on:click='clickColorHex("#996600",-20,72)' v-on:mouseover ='mouseOverColor("#996600")' alt='#996600' />
      <area style='cursor:pointer' shape='poly' coords='99,180,108,184,108,195,99,199,90,195,90,184' v-on:click='clickColorHex("#CC3300",-20,90)' v-on:mouseover ='mouseOverColor("#CC3300")' alt='#CC3300' />
      <area style='cursor:pointer' shape='poly' coords='117,180,126,184,126,195,117,199,108,195,108,184' v-on:click='clickColorHex("#993300",-20,108)' v-on:mouseover ='mouseOverColor("#993300")' alt='#993300' />
      <area style='cursor:pointer' shape='poly' coords='135,180,144,184,144,195,135,199,126,195,126,184' v-on:click='clickColorHex("#990000",-20,126)' v-on:mouseover ='mouseOverColor("#990000")' alt='#990000' />
      <area style='cursor:pointer' shape='poly' coords='153,180,162,184,162,195,153,199,144,195,144,184' v-on:click='clickColorHex("#800000",-20,144)' v-on:mouseover ='mouseOverColor("#800000")' alt='#800000' />
      <area style='cursor:pointer' shape='poly' coords='171,180,180,184,180,195,171,199,162,195,162,184' v-on:click='clickColorHex("#993333",-20,162)' v-on:mouseover ='mouseOverColor("#993333")' alt='#993333' />
      </map>
      <div id='selectedhexagon' style='visibility:hidden;position:relative;width:21px;height:21px;background-image:url("https://www.w3schools.com/colors/img_selectedcolor.gif");top: -80px; left: 144px;'></div>
    </b-col>
    </b-row> -->
  </b-container>
</template>
<script>
import { eventBus } from '../main.js'

export default {
  data () {
    return {
      object: null,
      objectX: 0,
      objectY: 0,
      objectFontSize: 0,
      objectFont: null,
      lineWidth: 0,
      objectBold: '',
      objectStyle: '',
      objectColor: '#000000',
      objectColorOld: '',
      canvas: null

    }
  },
  watch: {
  },
  methods: {
    moveXObject: function () {
      this.object.left = parseInt(this.objectX)
      eventBus.$emit('object', this.object)
    },
    moveYObject: function () {
      this.object.top = parseInt(this.objectY)
      eventBus.$emit('object', this.object)
    },
    resizeTextBox: function () {
      this.object.left = parseInt(this.objectX)
      if (this.objectFontSize === null) {
        this.objectFontSize = 5
      }
      this.object.fontSize = this.objectFontSize
      this.object.set('width', this.object.dynamicMinWidth)
      eventBus.$emit('object', this.object)
    },
    onChange (event) {
      if (event !== '') {
        this.object.set('fontFamily', event)
        eventBus.$emit('object', this.object)
      }
    },
    boldChk (event) {
      this.object.set('fontWeight', event)
      eventBus.$emit('object', this.object)
    },
    styleChk (event) {
      this.object.set('fontStyle', event)
      eventBus.$emit('object', this.object)
    },
    clickColor () {
      this.objectColorOld = this.objectColor
      this.object.set('fill', this.objectColor)
      eventBus.$emit('object', this.object)
    },
    clickColorHex (hex, seltop, selleft) {
      this.objectColorOld = hex
      if ((seltop + 200) > -1 && selleft > -1) {
        document.getElementById('selectedhexagon').style.top = seltop + 'px'
        document.getElementById('selectedhexagon').style.left = selleft + 'px'
        document.getElementById('selectedhexagon').style.visibility = 'visible'
      }
      this.object.set('fill', hex)
      eventBus.$emit('object', this.object)
    },
    mouseOverColor (hex) {
      this.object.set('fill', hex)
      eventBus.$emit('object', this.object)
    },
    mouseOutMap () {
      this.object.set('fill', this.objectColorOld)
      eventBus.$emit('object', this.object)
    }
  },
  mounted () {
  },
  created () {
    eventBus.$on('data', (object) => {
      this.object = object
      this.objectX = Math.round(this.object.left)
      this.objectY = Math.round(this.object.top)
      this.objectFontSize = this.object.fontSize * this.object.scaleY
      this.objectBold = object.fontWeight
      this.objectStyle = object.fontStyle
      this.objectFont = object.fontFamily
      this.objectColor = object.fill
      this.objectColorOld = object.fill
    })
    eventBus.$on('canvas', (canvas) => {
      this.canvas = canvas
    })
  }
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Kosugi&family=Kosugi+Maru&family=M+PLUS+1p&family=M+PLUS+Rounded+1c&family=Noto+Sans+JP&family=Noto+Serif+JP&family=Roboto&family=Sawarabi+Gothic&family=Sawarabi+Mincho&display=swap');
 canvas{
   border: 1px black solid;
 }
</style>
