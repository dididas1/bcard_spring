<template>
  <b-container fluid>
    <canvas id="canvas" width="660" height="400"></canvas>
  </b-container>
</template>

<script>
import { eventBus } from '../main.js'

export default {
  data () {
    return {
      canvas: null
    }
  },
  watch: {
  },
  methods: {
  },
  mounted () {
  },
  created () {
    eventBus.$on('canvas', (canvas) => {
      this.canvas = canvas
    })
  }
}
</script>
<style>
 canvas{
   border: 1px black solid;
 }
</style>
