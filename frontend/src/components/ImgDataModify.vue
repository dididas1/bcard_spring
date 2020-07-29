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
      this.object.width = this.object.dynamicMinWidth
      eventBus.$emit('object', this.object)
    },
    onChange (event) {
      if (event !== '') {
        this.object.fontFamily = event
        eventBus.$emit('object', this.object)
      }
    },
    boldChk (event) {
      this.object.fontWeight = event
      eventBus.$emit('object', this.object)
    },
    styleChk (event) {
      this.object.fontStyle = event
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
      console.log(object)
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
