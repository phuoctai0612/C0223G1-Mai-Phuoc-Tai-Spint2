import axios from "axios";

export async function getListAddress() {
    const res = await axios.get("http://localhost:8080/address");
    return res.data;
}
export async function findByIdAddress(id) {
    const res = await axios.get("http://localhost:8080/address/"+id);
    return res.data;
}
export async function getListProvinceAPI() {
    const res = await  axios
        .get(
        `https://provinces.open-api.vn/api/?depth=3`
        );
    return res.data;
}
export async function getListDistrictAPI() {
    const res = await  axios
        .get(
        `https://provinces.open-api.vn/api/?depth=2`
        );
    return res.data;
}
export async function createAddress(address) {
    const res = await axios.post("http://localhost:8080/address",address);
}
export async function editAddress(address) {
    const res = await axios.put("http://localhost:8080/address/"+address.id,address);
}
export async function deleteAddressAPI(id) {
    const res = await axios.delete("http://localhost:8080/address/"+id);
}
