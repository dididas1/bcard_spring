<template>
<div>
    <b-row class="my-1">
     <b-col sm="6">
      <b-card
          header="名刺"
          style="max-width: 40rem; margin: auto; margin-top: 2vh;"
          class="mb-2"
          border-variant="info"
          align="left">
            <ImgEditorComponets/>
      </b-card>
      <b-card
          header="名刺情報"
          style="max-width: 40rem; margin: auto; margin-top: 2vh;"
          class="mb-2"
          border-variant="info"
          align="left">
            <ImgDataModify/>
      </b-card>
     </b-col>
      <b-col sm="5">
        <b-card
          header="入力"
          style="max-width: 40rem; margin: auto; margin-top: 2vh;"
          class="mb-2"
          border-variant="info"
          align="left">
            <ImgEditorInput/>
        </b-card>
      </b-col>
    </b-row>

  </div>
</template>

<script>
// キャンバス用コンポーネントの読み込み
import ImgEditorComponets from '../components/ImgEditor'
import ImgEditorInput from '../components/ImgEditorInput'
import ImgDataModify from '../components/ImgDataModify'

export default {
  components: {
    ImgEditorInput,
    ImgEditorComponets,
    ImgDataModify
  },
  data () {
    return {
      radius: 50
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
#view{
  margin-left: 70px;
}
</style>
