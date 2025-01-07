<template>
  <div>
   

    <!-- İçerik Bölümü -->
    <section class="content">
      <div class="container">
        <form @submit.prevent="createEvent" class="form">
          <!-- Etkinlik Adı -->
          <div class="form-group">
            <label for="name">ETKİNLİK İSMİ</label>
            <input type="text" v-model="name" id="name" required />
          </div>

          <!-- Şehir Seçimi -->
          <div class="form-group">
            <label for="city">ADRES</label>
            <select id="city" v-model="selectedCity" @change="updateDistricts" required style="min-width: 100px; min-height: 50px; padding: 2px; text-align: center;">
              <option value="" disabled selected>Şehir seç</option>
              <option v-for="city in cities" :key="city.id" :value="city.id">
                {{ city.name }}
              </option>
            </select>
          </div>

          <!-- İlçe Seçimi -->
          <div v-if="districts.length > 0" class="form-group">
            <label for="district"></label>
            <select id="district" v-model="selectedDistrict" required style="min-width: 100px; min-height: 50px; text-align: center; padding: 2px;">
              <option value="" disabled selected>İlçe</option>
              <option v-for="district in districts" :key="district.id" :value="district.id">
                {{ district.name }}
              </option>
            </select>
          </div>
          <div v-if="districts.length > 0" class="form-group">
            <textarea  placeholder="Dudullu OSB/Nato yolu/....." name="Adress" id="adres" style="font-size: 20px; font-style: italic; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif; min-width: 300px;min-height: 100px; padding: 5px;"></textarea>
          </div>

          <!-- Tarih ve Saat Seçimi -->
          <div class="form-group">
            <label for="dates">Event Dates and Times</label>
            <div v-for="(dateGroup, dateIndex) in dates" :key="dateIndex" class="date-group">
              <div class="date-entry">
                <input
                  type="text"
                  :ref="'datepicker' + dateIndex"
                  placeholder="gg/aa/yyyy"
                  required
                  @focus="initializeDatePicker(dateIndex)"
                  readonly
                />
                <button type="button" @click="removeDate(dateIndex)">TARİHİ SİL</button>
              </div>
              <div v-for="(time, timeIndex) in dateGroup.times" :key="timeIndex" class="time-group">
                <input placeholder="09.30"
                  type="text"
                  v-model="dateGroup.times[timeIndex]"
                  :ref="'timepicker' + dateIndex + '_' + timeIndex"
                  @focus="initializeTimePicker(dateIndex, timeIndex)"
                  required
                  readonly
                />
                <button type="button" @click="removeTime(dateIndex, timeIndex)">SAATİ SİL</button>
              </div>
              <button type="button" @click="addTime(dateIndex)">SAAT EKLE</button>
            </div>
            <button type="button" @click="addDate">TARİH EKLE</button>
          </div>

          <!-- Oylama Bitiş Tarihi -->
          <div class="form-group" style="text-align: center;">
            <label for="votingEndDate" style="text-align: center;">OYLAMA BİTİŞ TARİHİ</label>
            <input
              type="text"
              ref="votingDatePicker"
              placeholder="gg/aa/yyyy"
              required
              readonly
              @focus="initializeVotingDatePicker"
            />
          </div>

          <button type="submit">ETKİNLİK OLUŞTUR</button>
        </form>
      </div>
    </section>
  </div>
</template>

<script>
import flatpickr from "flatpickr";
import "flatpickr/dist/flatpickr.min.css";
import { Turkish } from "flatpickr/dist/l10n/tr";
import provinces from "../assets/json/provinces.json";
import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8001", // API'nin çalıştığı adres ve port
  headers: {
    "Content-Type": "application/json",
  },
});

export default {
  data() {
    return {
      name: "",
      dates: [
        {
          date: "",
          times: [""],
        },
      ],
      votingEndDate: "",
      cities: [],
      districts: [],
      selectedCity: "",
      selectedDistrict: "",
    };
  },
  mounted() {
    this.loadCities();
  },
  methods: {
    loadCities() {
      this.cities = provinces.data.map((province) => ({
        id: province.id,
        name: province.name,
        districts: province.districts,
      }));
    },
    updateDistricts() {
      const selectedCity = this.cities.find((city) => city.id === this.selectedCity);
      this.districts = selectedCity ? selectedCity.districts : [];
    },
    addDate() {
      this.dates.push({
        date: "",
        times: [""],
      });
    },
    removeDate(index) {
      this.dates.splice(index, 1);
    },
    addTime(dateIndex) {
      this.dates[dateIndex].times.push("");
    },
    removeTime(dateIndex, timeIndex) {
      this.dates[dateIndex].times.splice(timeIndex, 1);
    },
    initializeDatePicker(dateIndex) {
      const datePickerRef = this.$refs["datepicker" + dateIndex];
      if (datePickerRef && !datePickerRef._flatpickr) {
        flatpickr(datePickerRef, {
          dateFormat: "d/m/Y",
          locale: Turkish,
          onChange: (selectedDates, dateStr) => {
            this.dates[dateIndex].date = dateStr;
          },
        });
      }
    },
    initializeTimePicker(dateIndex, timeIndex) {
      const timeInputRef = this.$refs["timepicker" + dateIndex + "_" + timeIndex];
      if (timeInputRef && !timeInputRef._flatpickr) {
        flatpickr(timeInputRef, {
          enableTime: true,
          noCalendar: true,
          time_24hr: true,
          locale: Turkish,
          onChange: (selectedDates, dateStr) => {
            this.dates[dateIndex].times[timeIndex] = dateStr;
          },
        });
      }
    },
    initializeVotingDatePicker() {
      const votingDatePickerRef = this.$refs.votingDatePicker;
      if (votingDatePickerRef && !votingDatePickerRef._flatpickr) {
        flatpickr(votingDatePickerRef, {
          dateFormat: "d/m/Y",
          locale: Turkish,
          onChange: (selectedDates, dateStr) => {
            this.votingEndDate = dateStr;
          },
        });
      }
    },
    async createEvent() {
      try {
        const formattedDates = this.dates.map((dateGroup) => ({
          date: dateGroup.date,
          times: dateGroup.times,
        }));

        // API isteği ile event verilerini göndermek
        const response = await axiosInstance.post("/api/events/create", {
          name: this.name,
          city: this.selectedCity,
          district: this.selectedDistrict,
          dates: formattedDates,
          votingEndDate: this.votingEndDate,
        },{  withCredentials: true, // Include cookies/auth tokens
        });

        console.log("Event created successfully:", response.data);
        alert("Event created successfully!");
      } catch (error) {
        console.error("Error creating event:", error);
        if (error.response && error.response.status === 404) {
          alert("Endpoint bulunamadı. Lütfen API adresini kontrol edin.");
        } else {
          alert("Failed to create event. Please check your connection or try again.");
        }
      }
    },
  },
};
</script>

<style src="../style/EventFom.css"></style>
