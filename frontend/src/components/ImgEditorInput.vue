<template>
<b-container fluid>
  <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">お名前</label>
    </b-col>
    <b-col sm="3">
      <b-form-input size="sm" v-model="namek1" v-on:keyup="addNamek1"></b-form-input>
    </b-col>
    <b-col sm="3">
      <b-form-input size="sm" v-model="namek2" v-on:keyup="addNamek2"></b-form-input>
    </b-col>
  </b-row>
   <b-row class="my-1">
     <b-col sm="3">
       <label for="input-small">読み</label>
    </b-col>
    <b-col sm="3">
      <b-form-input size="sm" v-model="namey1" v-on:keyup="addNamey1"></b-form-input>
    </b-col>
    <b-col sm="3">
        <b-form-input size="sm" v-model="namey2" v-on:keyup="addNamey2"></b-form-input>
    </b-col>
  </b-row>
   <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">会社名</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="cname" v-on:keyup="addCname"></b-form-input>
    </b-col>
  </b-row>
    <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">所属</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="dept" v-on:keyup="addDept"></b-form-input>
    </b-col>
  </b-row>
  <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">役職</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="rank" v-on:keyup="addRank"></b-form-input>
    </b-col>
  </b-row>
  <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">郵便番号</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="zcode" v-on:keyup="addZcode"></b-form-input>
    </b-col>
  </b-row>
  <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">住所１</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="adr1" v-on:keyup="addAdr"></b-form-input>
    </b-col>
  </b-row>
  <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">住所２</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="adr2" v-on:keyup="addAdr"></b-form-input>
    </b-col>
  </b-row>
    <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">電話番号</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="tel" v-on:keyup="addTel"></b-form-input>
    </b-col>
  </b-row>
    <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">FAX</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="fax" v-on:keyup="addFax"></b-form-input>
    </b-col>
  </b-row>
    <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">EMAIL</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="email" v-on:keyup="addEmail"></b-form-input>
    </b-col>
  </b-row>
    <b-row class="my-1">
     <b-col sm="3">
      <label for="input-small">ホーム</label>
    </b-col>
    <b-col sm="6">
      <b-form-input size="sm" v-model="page" v-on:keyup="addPage"></b-form-input>
    </b-col>
  </b-row>
    <b-input-group>
      <b-button variant="outline-primary" v-on:click='addGrid'>Add</b-button>
      <b-button variant="outline-primary" v-on:click='removeGrid'>Remove</b-button>
      <b-button variant="outline-primary" v-on:click='saveImg'>저장</b-button>
      <b-button variant="outline-primary" v-on:click='setData'>표시</b-button>
    </b-input-group>
  </b-container>
</template>

<script>
import { eventBus } from '../main.js'
import { fabric } from 'fabric'

export default {
  name: 'ImgEditorInput',
  data () {
    return {
      datas: [],
      namek1: '',
      namek2: '',
      namey1: '',
      namey2: '',
      cname: '',
      dept: '',
      rank: '',
      zcode: '',
      adr1: '',
      adr2: '',
      tel: '',
      fax: '',
      email: '',
      page: '',
      canvas: null,
      gridGroup: null,
      namek1Box: null,
      namek2Box: null,
      namey1Box: null,
      namey2Box: null,
      cnameBox: null,
      deptBox: null,
      rankBox: null,
      zcodeBox: null,
      adr1Box: null,
      adr2Box: null,
      telBox: null,
      faxBox: null,
      emailBox: null,
      pageBox: null,
      imageBox: null,
      namek1Option: null,
      namek2Option: null,
      namey1Option: null,
      namey2Option: null,
      cnameOption: null,
      deOption: null,
      rankOption: null,
      zcodeOption: null,
      adrOption: null,
      telOption: null,
      faxOption: null,
      emailOption: null,
      pageOption: null,
      imageOption: null
    }
  },
  methods: {
    addText: function () {

    },
    addNamek1: function () {
      var event = this.namek1Box
      event.set('text', this.namek1)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addNamek2: function () {
      var event = this.namek2Box
      event.set('text', this.namek2)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addNamey1: function () {
      var event = this.namey1Box
      event.set('text', this.namey1)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addNamey2: function () {
      var event = this.namey2Box
      event.set('text', this.namey2)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addCname: function () {
      var event = this.cnameBox
      event.set('text', this.cname)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addDept: function () {
      var event = this.deptBox
      event.set('text', this.dept)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addRank: function () {
      var event = this.rankBox
      event.set('text', this.rank)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addZcode: function () {
      var event = this.zcodeBox
      event.set('text', this.zcode)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addAdr: function () {
      var event = this.adrBox
      event.set('text', this.adr1 + ' ' + this.adr2)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addTel: function () {
      var event = this.telBox
      event.set('text', this.tel)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addFax: function () {
      var event = this.faxBox
      event.set('text', this.fax)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addEmail: function () {
      var event = this.emailBox
      event.set('text', this.email)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    addPage: function () {
      var event = this.pageBox
      event.set('text', this.page)
      this.canvas.renderAll()
      this.sizeModify(event)
    },
    saveImg: function () {
      var nameObject = this.getObjects(this.canvas.getObjects('textbox'), 'namek1')
      var nameObject2 = this.getObjects(this.canvas.getObjects('textbox'), 'namek2')
      var nameText = nameObject.text + ' ' + nameObject2.text
      var nameLeft = nameObject.left
      var nameTop = nameObject.top
      var nameColor = nameObject.fill
      var nameWidth = nameObject.width * nameObject.scaleX
      var nameHeight = nameObject.height * nameObject.scaleY
      var nameFontSize = nameObject.fontSize * nameObject.scaleY
      var nameTa = nameObject.textAlign
      var name2Object = this.getObjects(this.canvas.getObjects('textbox'), 'namey1')
      var name2Object2 = this.getObjects(this.canvas.getObjects('textbox'), 'namey2')
      var name2Text = name2Object.text + ' ' + name2Object2.text
      var name2Left = name2Object.left
      var name2Top = name2Object.top
      var name2Color = name2Object.fill
      var name2Width = name2Object.width * name2Object.scaleX
      var name2Height = name2Object.height * name2Object.scaleY
      var name2FontSize = name2Object.fontSize * name2Object.scaleY
      var name2Ta = name2Object.textAlign
      var cnameObject = this.getObjects(this.canvas.getObjects('textbox'), 'cname')
      var cnameText = cnameObject.text
      var cnameLeft = cnameObject.left
      var cnameTop = cnameObject.top
      var cnameColor = cnameObject.fill
      var cnameWidth = cnameObject.width * cnameObject.scaleX
      var cnameHeight = cnameObject.height * cnameObject.scaleY
      var cnameFontSize = cnameObject.fontSize * cnameObject.scaleY
      var cnameTa = cnameObject.textAlign
      var deptObject = this.getObjects(this.canvas.getObjects('textbox'), 'dept')
      var deptText = deptObject.text
      var deptLeft = deptObject.left
      var deptTop = deptObject.top
      var deptColor = deptObject.fill
      var deptWidth = deptObject.width * deptObject.scaleX
      var deptHeight = deptObject.height * deptObject.scaleY
      var deptFontSize = deptObject.fontSize * deptObject.scaleY
      var deptTa = deptObject.textAlign
      var rankObject = this.getObjects(this.canvas.getObjects('textbox'), 'rank')
      var rankText = rankObject.text
      var rankLeft = rankObject.left
      var rankTop = rankObject.top
      var rankColor = rankObject.fill
      var rankWidth = rankObject.width * rankObject.scaleX
      var rankHeight = rankObject.height * rankObject.scaleY
      var rankFontSize = rankObject.fontSize * rankObject.scaleY
      var rankTa = rankObject.textAlign
      var zcodeObject = this.getObjects(this.canvas.getObjects('textbox'), 'zcode')
      var zcodeText = zcodeObject.text
      var zcodeLeft = zcodeObject.left
      var zcodeTop = zcodeObject.top
      var zcodeColor = zcodeObject.fill
      var zcodeWidth = zcodeObject.width * zcodeObject.scaleX
      var zcodeHeight = zcodeObject.height * zcodeObject.scaleY
      var zcodeFontSize = zcodeObject.fontSize * zcodeObject.scaleY
      var zcodeTa = zcodeObject.textAlign
      var adrObject = this.getObjects(this.canvas.getObjects('textbox'), 'adr')
      var adrText = adrObject.text
      var adrLeft = adrObject.left
      var adrTop = adrObject.top
      var adrColor = adrObject.fill
      var adrWidth = adrObject.width * adrObject.scaleX
      var adrHeight = adrObject.height * adrObject.scaleY
      var adrFontSize = adrObject.fontSize * adrObject.scaleY
      var adrTa = adrObject.textAlign
      var telObject = this.getObjects(this.canvas.getObjects('textbox'), 'tel')
      var telText = telObject.text
      var telLeft = telObject.left
      var telTop = telObject.top
      var telColor = telObject.fill
      var telWidth = telObject.width * telObject.scaleX
      var telHeight = telObject.height * telObject.scaleY
      var telFontSize = telObject.fontSize * telObject.scaleY
      var telTa = telObject.textAlign
      var faxObject = this.getObjects(this.canvas.getObjects('textbox'), 'fax')
      var faxText = faxObject.text
      var faxLeft = faxObject.left
      var faxTop = faxObject.top
      var faxColor = faxObject.fill
      var faxWidth = faxObject.width * faxObject.scaleX
      var faxHeight = faxObject.height * faxObject.scaleY
      var faxFontSize = faxObject.fontSize * faxObject.scaleY
      var faxTa = faxObject.textAlign
      var emailObject = this.getObjects(this.canvas.getObjects('textbox'), 'email')
      var emailText = emailObject.text
      var emailLeft = emailObject.left
      var emailTop = emailObject.top
      var emailColor = emailObject.fill
      var emailWidth = emailObject.width * emailObject.scaleX
      var emailHeight = emailObject.height * emailObject.scaleY
      var emailFontSize = emailObject.fontSize * emailObject.scaleY
      var emailTa = emailObject.textAlign
      var pageObject = this.getObjects(this.canvas.getObjects('textbox'), 'page')
      var pageText = pageObject.text
      var pageLeft = pageObject.left
      var pageTop = pageObject.top
      var pageColor = pageObject.fill
      var pageWidth = pageObject.width * pageObject.scaleX
      var pageHeight = pageObject.height * pageObject.scaleY
      var pageFontSize = pageObject.fontSize * pageObject.scaleY
      var pageTa = pageObject.textAlign
      var imgObject = this.getObjects(this.canvas.getObjects('image'), 'img')
      console.log(imgObject)
      var imgPath = imgObject._element.src
      var imgX = imgObject.left
      var imgY = imgObject.top
      var imgScaleX = imgObject.scaleX
      var imgScaleY = imgObject.scaleY

      this.$http.post('/imgDataInsert',
        { iNo: 1,
          nNo: 2,
          name: nameText,
          nameX: nameLeft,
          nameY: nameTop,
          nameColor: nameColor,
          nameFont: nameFontSize,
          nameW: nameWidth,
          nameTa: nameTa,
          nameHt: nameHeight,
          name2: name2Text,
          name2X: name2Left,
          name2Y: name2Top,
          name2Color: name2Color,
          name2Font: name2FontSize,
          name2W: name2Width,
          name2Ta: name2Ta,
          name2Ht: name2Height,
          cname: cnameText,
          cnameX: cnameLeft,
          cnameY: cnameTop,
          cnameColor: cnameColor,
          cnameFont: cnameFontSize,
          cnameW: cnameWidth,
          cnameTa: cnameTa,
          cnameHt: cnameHeight,
          dept: deptText,
          deptX: deptLeft,
          deptY: deptTop,
          deptColor: deptColor,
          deptFont: deptFontSize,
          deptW: deptWidth,
          deptTa: deptTa,
          deptHt: deptHeight,
          rankText: rankText,
          rankX: rankLeft,
          rankY: rankTop,
          rankColor: rankColor,
          rankFont: rankFontSize,
          rankW: rankWidth,
          rankTa: rankTa,
          rankHt: rankHeight,
          zcode: zcodeText,
          zcodeX: zcodeLeft,
          zcodeY: zcodeTop,
          zcodeColor: zcodeColor,
          zcodeFont: zcodeFontSize,
          zcodeW: zcodeWidth,
          zcodeTa: zcodeTa,
          zcodeHt: zcodeHeight,
          adr: adrText,
          adrX: adrLeft,
          adrY: adrTop,
          adrColor: adrColor,
          adrFont: adrFontSize,
          adrW: adrWidth,
          adrTa: adrTa,
          adrHt: adrHeight,
          tel: telText,
          telX: telLeft,
          telY: telTop,
          telColor: telColor,
          telFont: telFontSize,
          telW: telWidth,
          telTa: telTa,
          telHt: telHeight,
          fax: faxText,
          faxX: faxLeft,
          faxY: faxTop,
          faxColor: faxColor,
          faxFont: faxFontSize,
          faxW: faxWidth,
          faxTa: faxTa,
          faxHt: faxHeight,
          email: emailText,
          emailX: emailLeft,
          emailY: emailTop,
          emailColor: emailColor,
          emailFont: emailFontSize,
          emailW: emailWidth,
          emailTa: emailTa,
          emailHt: emailHeight,
          page: pageText,
          pageX: pageLeft,
          pageY: pageTop,
          pageColor: pageColor,
          pageFont: pageFontSize,
          pageW: pageWidth,
          pageTa: pageTa,
          pageHt: pageHeight,
          imgPath: imgPath,
          imgX: imgX,
          imgY: imgY,
          imgScaleX: imgScaleX,
          imgScaleY: imgScaleY }
      ).then(response => {
        console.warn(response)
      }).catch((ex) => {
        console.warn('ERROR!!!!! : ', ex)
      })
      /*  var image = new Image()
      image = this.canvas.toDataURL('image/jpg')
      var formdata = image.replace(/^data:image\/(png|jpg);base64,/, '')
      this.$http.post('/imgModify',
        { imgByte: formdata }
      ).then(response => {
        console.warn(response)
      }).catch((ex) => {
        console.warn('ERROR!!!!! : ', ex)
      }) */
    },
    addGrid: function () {
      if (this.gridGroup) return
      var gridoption = {
        stroke: '#D5D5D5',
        strokeWidth: 1,
        strokeDashArray: [1, 1]
      }
      var gridLines = []
      var index
      if (this.canvas.width < this.canvas.height) {
        index = this.canvas.height
      } else {
        index = this.canvas.width
      }
      for (var x = 30; x <= (index); x += 50) {
        gridLines.push(new fabric.Line([x, 0, x, index], gridoption))
      }
      for (var y = 25; y <= (index); y += 50) {
        gridLines.push(new fabric.Line([0, y, index, y], gridoption))
      }
      this.gridGroup = new fabric.Group(gridLines, {
        selectable: false,
        evented: false
      })
      this.gridGroup.addWithUpdate()
      this.canvas.add(this.gridGroup)
      eventBus.$emit('canvas', this.canvas)
    },
    removeGrid: function () {
      this.gridGroup && this.canvas.remove(this.gridGroup)
      this.gridGroup = null
      eventBus.$emit('canvas', this.canvas)
    },
    viewText: function () {

    },
    setData: function () {
      this.$http.get('/imgData', { params: { nNo: '2' } })
        .then(res => {
          this.datas = res.data.result
          this.namek1Option = {
            width: this.datas.nameW,
            left: this.datas.nameX,
            top: this.datas.nameY,
            fontSize: this.datas.nameFont,
            textAlign: this.datas.nameTa,
            fixedWidth: this.datas.nameW,
            baseFontSize: this.datas.nameFont,
            name: 'namek1',
            fill: this.datas.nameColor
          }
          this.namek2Option = {
            width: this.datas.nameW,
            left: this.datas.nameX + 75,
            top: this.datas.nameY,
            fontSize: this.datas.nameFont,
            textAlign: this.datas.nameTa,
            fixedWidth: this.datas.nameW,
            baseFontSize: this.datas.nameFont,
            name: 'namek2',
            fill: this.datas.nameColor
          }
          this.namey1Option = {
            width: this.datas.name2W,
            left: this.datas.name2X,
            top: this.datas.name2Y,
            fontSize: this.datas.name2Font,
            textAlign: this.datas.name2Ta,
            fixedWidth: this.datas.name2W,
            baseFontSize: this.datas.name2Font,
            name: 'namey1',
            fill: this.datas.name2Color
          }
          this.namey2Option = {
            width: this.datas.name2W,
            left: this.datas.name2X + 75,
            top: this.datas.name2Y,
            fontSize: this.datas.name2Font,
            textAlign: this.datas.name2Ta,
            fixedWidth: this.datas.name2W,
            baseFontSize: this.datas.name2Font,
            name: 'namey2',
            fill: this.datas.name2Color
          }
          this.cnameOption = {
            width: this.datas.cnameW,
            left: this.datas.cnameX,
            top: this.datas.cnameY,
            fontSize: parseInt(this.datas.cnameFont),
            textAlign: this.datas.cnameTa,
            fixedWidth: this.datas.cnameW,
            baseFontSize: parseInt(this.datas.cnameFont),
            name: 'cname',
            fill: this.datas.cnameColor,
            height: this.datas.cnameHt
          }

          this.deptOption = {
            width: this.datas.deptW,
            left: this.datas.deptX,
            top: this.datas.deptY,
            fontSize: this.datas.deptFont,
            textAlign: this.datas.deptTa,
            fixedWidth: this.datas.deptW,
            baseFontSize: this.datas.deptFont,
            name: 'dept',
            fill: this.datas.deptColor
          }
          this.rankOption = {
            width: this.datas.rankW,
            left: this.datas.rankX,
            top: this.datas.rankY,
            fontSize: this.datas.rankFont,
            textAlign: this.datas.rankTa,
            fixedWidth: this.datas.rankW,
            baseFontSize: this.datas.rankFont,
            name: 'rank',
            fill: this.datas.rankColor
          }
          this.zcodeOption = {
            width: this.datas.zcodeW,
            left: this.datas.zcodeX,
            top: this.datas.zcodeY,
            fontSize: this.datas.zcodeFont,
            textAlign: this.datas.zcodeTa,
            fixedWidth: this.datas.zcodeW,
            baseFontSize: this.datas.zcodeFont,
            name: 'zcode',
            fill: this.datas.zcodeColor
          }
          this.adrOption = {
            width: this.datas.adrW,
            left: this.datas.adrX,
            top: this.datas.adrY,
            fontSize: this.datas.adrFont,
            textAlign: this.datas.adrTa,
            fixedWidth: this.datas.adrW,
            baseFontSize: this.datas.adrFont,
            name: 'adr',
            fill: this.datas.adrColor
          }
          this.telOption = {
            width: this.datas.telW,
            left: this.datas.telX,
            top: this.datas.telY,
            fontSize: this.datas.telFont,
            textAlign: this.datas.telTa,
            fixedWidth: this.datas.telW,
            baseFontSize: this.datas.telFont,
            name: 'tel',
            fill: this.datas.telColor
          }
          this.faxOption = {
            width: this.datas.faxW,
            left: this.datas.faxX,
            top: this.datas.faxY,
            fontSize: this.datas.faxFont,
            textAlign: this.datas.faxTa,
            fixedWidth: this.datas.faxW,
            baseFontSize: this.datas.faxFont,
            name: 'fax',
            fill: this.datas.faxColor
          }
          this.emailOption = {
            width: this.datas.emailW,
            left: this.datas.emailX,
            top: this.datas.emailY,
            fontSize: this.datas.emailFont,
            textAlign: this.datas.emailTa,
            fixedWidth: this.datas.emailW,
            baseFontSize: this.datas.emailFont,
            name: 'email',
            fill: this.datas.emailColor
          }
          this.pageOption = {
            width: this.datas.pageW,
            left: this.datas.pageX,
            top: this.datas.pageY,
            fontSize: this.datas.pageFont,
            textAlign: this.datas.pageTa,
            fixedWidth: this.datas.pageW,
            baseFontSize: this.datas.pageFont,
            name: 'page',
            fill: this.datas.pageColor
          }
          this.imageOption = {
            left: this.datas.imgX,
            top: this.datas.imgY,
            scaleX: this.datas.imgScaleX,
            scaleY: this.datas.imgScaleY,
            name: 'img'
          }
          var vm = this
          var arr = this.remakeText(this.datas.name)
          this.namek1 = arr['text1']
          this.namek2 = arr['text2']
          arr = this.remakeText(this.datas.name2)
          this.namey1 = arr['text1']
          this.namey2 = arr['text2']
          this.cname = this.datas.cname
          this.dept = this.datas.dept
          this.rank = this.datas.rankText
          this.zcode = this.datas.zcode
          arr = this.remakeText(this.datas.adr)
          this.adr1 = arr['text1']
          this.adr2 = arr['text2']
          this.tel = this.datas.tel
          this.fax = this.datas.fax
          this.email = this.datas.email
          this.page = this.datas.page

          this.namek1Box = new fabric.Textbox(this.namek1, this.namek1Option)
          this.namek2Box = new fabric.Textbox(this.namek2, this.namek2Option)
          this.namey1Box = new fabric.Textbox(this.namey1, this.namey1Option)
          this.namey2Box = new fabric.Textbox(this.namey2, this.namey2Option)
          this.cnameBox = new fabric.Textbox(this.cname, this.cnameOption)
          this.deptBox = new fabric.Textbox(this.dept, this.deptOption)
          this.rankBox = new fabric.Textbox(this.rank, this.rankOption)
          this.zcodeBox = new fabric.Textbox(this.zcode, this.zcodeOption)
          this.adrBox = new fabric.Textbox(this.datas.adr, this.adrOption)
          this.telBox = new fabric.Textbox(this.tel, this.telOption)
          this.faxBox = new fabric.Textbox(this.fax, this.faxOption)
          this.emailBox = new fabric.Textbox(this.email, this.emailOption)
          this.pageBox = new fabric.Textbox(this.page, this.pageOption)
          var imgObj = new Image()
          imgObj.src = this.datas.imgPath
          imgObj.onload = function () {
            vm.imageBox = new fabric.Image(imgObj, vm.$data.imageOption)
            vm.canvas.add(vm.imageBox)
          }
          this.canvas.add(this.namek1Box)
          this.canvas.add(this.namek2Box)
          this.canvas.add(this.namey1Box)
          this.canvas.add(this.namey2Box)
          this.canvas.add(this.cnameBox)
          this.canvas.add(this.deptBox)
          this.canvas.add(this.rankBox)
          this.canvas.add(this.zcodeBox)
          this.canvas.add(this.adrBox)
          this.canvas.add(this.telBox)
          this.canvas.add(this.faxBox)
          this.canvas.add(this.emailBox)
          this.canvas.add(this.pageBox)
          this.canvas.renderAll()
        })
        .catch(err => {
          console.log(err)
        })
    },
    sizeModify: function (event) {
      var largest = event.__lineWidths[0]
      if (event.width >= largest) {
        if (largest !== 0) {
          event.width = largest
        }
      }
      /* if (event.width >= largest) {
        if (Math.round(event.fontSize) < event.baseFontSize) {
          event.fontSize *= event.width / (largest + 1)
        } else {
          event.fontSize = event.baseFontSize
        }
      }
      if (event.width > event.fixedWidth) {
        event.fontSize *= event.fixedWidth / (event.width + 1)
        event.width = event.fixedWidth
      } */
    },
    setCanvas: function () {
      var canvas = new fabric.Canvas('canvas')
      this.canvas = canvas

      fabric.Image.fromURL(this.$imgPath + 'smp.png', function (oImg) {
        oImg.set({
          // Set the image size by scale, which is the same size as the canvas
          scaleX: canvas.width / oImg.width,
          scaleY: canvas.height / oImg.height
        })
        // Setting Background
        canvas.setBackgroundImage(oImg, canvas.renderAll.bind(canvas))
        canvas.renderAll()
        eventBus.$emit('canvas', canvas)
      })
    },
    // nameでcanvasのOBJECT取得
    getObjects: function (objects, name) {
      var object = null
      for (var i = 0; i < objects.length; i++) {
        if (objects[i].name && objects[i].name === name) {
          object = objects[i]
          break
        }
      }
      return object
    },
    remakeText: function (text) {
      var index = text.indexOf(' ')
      var text1 = text.substring(0, index)
      var text2 = text.substring(index + 1, text.length)
      var arry = { text1, text2 }
      return arry
    }
  },
  mounted () {
    this.setCanvas()
    /*  this.setData() */

    var vm = this
    this.canvas.on('text:changed', function (opt) {
      var t1 = opt.target
      var largest = t1.__lineWidths[0]
      if (t1.width >= largest) {
        if (largest !== 0) {
          t1.width = largest
        }
      }
      if (opt.target.name === 'namek1') {
        vm.$data.namek2Box.left = opt.target.width + 70
      }
      if (opt.target.name === 'namey1') {
        vm.$data.namey2Box.left = opt.target.width + 70
      }
      /* if (t1.width >= largest) {
        if (Math.round(t1.fontSize) < t1.baseFontSize) {
          t1.fontSize *= t1.width / (largest)
        } else {
          t1.fontSize = t1.baseFontSize
        }
      }
      if (t1.width > t1.fixedWidth) {
        t1.fontSize *= t1.fixedWidth / (t1.width)
        t1.width = t1.fixedWidth
      } */
      var index = 0
      var text1 = ''
      var text2 = ''
      if (t1.name === 'cname') {
        vm.$data.cname = t1.text
      } else if (t1.name === 'namek1') {
        vm.$data.namek1 = t1.text
      } else if (t1.name === 'namek2') {
        vm.$data.namek2 = t1.text
      } else if (t1.name === 'namey1') {
        vm.$data.namey1 = t1.text
      } else if (t1.name === 'namey2') {
        vm.$data.namey2 = t1.text
      } else if (t1.name === 'dept') {
        vm.$data.dept = t1.text
      } else if (t1.name === 'rank') {
        vm.$data.rank = t1.text
      } else if (t1.name === 'zcode') {
        vm.$data.zcode = t1.text
      } else if (t1.name === 'adr') {
        index = t1.text.indexOf(' ')
        text1 = t1.text.substring(0, index)
        text2 = t1.text.substring(index + 1, t1.text.length)
        vm.$data.adr1 = text1
        vm.$data.adr2 = text2
      } else if (t1.name === 'tel') {
        vm.$data.tel = t1.text
      } else if (t1.name === 'fax') {
        vm.$data.fax = t1.text
      } else if (t1.name === 'email') {
        vm.$data.email = t1.text
      } else if (t1.name === 'page') {
        vm.$data.page = t1.text
      }
    })
    // objectクリック時情報渡す。
    this.canvas.on('mouse:up', function (opt) {
      var t1 = opt.target
      if (t1 != null) {
        eventBus.$emit('data', t1)
      }
    })
    this.canvas.on('selection:cleared', function () {
    })
    // 多重選択禁止。
    this.canvas.on('selection:created', (e) => {
      if (e.target.type === 'activeSelection') {
        this.canvas.discardActiveObject()
      } else {
        // do nothing
      }
    })
    eventBus.$on('object', (object) => {
      vm.$data.canvas.requestRenderAll()
      eventBus.$emit('canvas', vm.$data.canvas)
    })
  },
  beforeMount () {

  }
}
</script>
<style>
</style>
