<template>
  <div>
    <v-row>
      <v-col cols="12">
        <v-form class="ma-4 searchBox">
          <v-combobox class="searchTypeBox" label="Type" v-model="searchInfo.types" :items="typeList"
                      variant="underlined"></v-combobox>
          <v-text-field class="searchValueBox" v-model="searchInfo.keyword" label="Keyword" variant="underlined"
                        required></v-text-field>
          <v-btn @click="clickSearch()" variant="text" style="margin-top: 0.7em;">Search</v-btn>
        </v-form>
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import {ref} from "vue";
const props = defineProps(['pageSearch'])
const emits = defineEmits([ 'handleRollingSearch'])

const clickSearch = () => {
  emits('handleRollingSearch', searchInfo.value)
}
const searchInfo = ref({types: props.pageSearch.types, keyword: props.pageSearch.keyword})
const typeList = ref(['TITLE', 'TARGET'])
</script>

<style scoped>
.searchBox {
  display: flex;
  width: 25vw;
  float: right;
}

.searchTypeBox {
  width: 6vw;
}

.searchValueBox {
  width: 12vw;
}
</style>
