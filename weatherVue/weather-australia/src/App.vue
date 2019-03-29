<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view/> -->
    <el-select v-model="value" @change="getSelect" placeholder="请选择">
    <el-option
    v-for="item in options"
    :key="item.value"
    :label="item.label"
    :value="item.value">
    </el-option>
    </el-select>

    <div>
      <el-table
      :data="weatherData"
      style="width: 100%">
      <el-table-column
        prop="description"
        label="description"
        width="180">
      </el-table-column>
      <el-table-column
        prop="tempMin"
        label="temp_min"
        width="180">
      </el-table-column>
      <el-table-column
        prop="tempMax"
        label="temp_max ">
      </el-table-column>
      <el-table-column
        prop="address"
        label="address">
      </el-table-column>
      <el-table-column
        prop="windSpeed"
        label="wind speed">
      </el-table-column>
    </el-table>
    </div>

  

  </div>
</template>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script >
import axios from "axios";

export default {
  
data: ()=>{
return {
weatherData:[],
options: [
{value: 'Melbourne',
label: 'Melbourne'}, 
{value: 'Sydney',
label: 'Sydney'}, 
{value: 'Wollongong',
label: 'Wollongong. '}
],
value: ''}
},
methods: {
getSelect (data){
let jsonData = {"name":data}
let that = this;
axios.post('/login/australia/weather', jsonData)
.then(function (res) {
console.log(res);
console.log(res.data.weather[0].description, res.data.main.temp_min, res.data.main.temp_max, res.data.name, res.data.wind.speed);
that.weatherData=[{
  "description":res.data.weather[0].description,
  "tempMin":res.data.main.temp_min,
  "tempMax":res.data.main.temp_max,
  "address":res.data.name,
  "windSpeed":res.data.wind.speed
}];




});

}
}
}
</script>