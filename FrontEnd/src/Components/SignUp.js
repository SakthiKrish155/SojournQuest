// // import { Link } from 'react-router-dom';
// // import { useState } from 'react';
// // import {toast ,ToastContainer} from 'react-toastify'
// // import 'react-toastify/dist/ReactToastify.css';

// // const SignUp = () => {
// //     const [formData, setFormData] = useState({
// //         fullname: '',
// //         email: '',
// //         password: '',
// //         phone: ''
// //     });

// //     const handleInputChange = (event) => {
// //         const { name, value } = event.target;
// //         setFormData({ ...formData, [name]: value });
// //     };

// //     const handleSubmit = (event) => {
// //         event.preventDefault();
// //         // Check if any field is empty
// //         if (Object.values(formData).some((field) => field.trim() === '')) {
// //             toast.error('Please fill the details', {
// //                 position: 'top-center',
// //                 autoClose: 5000,
// //                 hideProgressBar: false,
// //                 closeOnClick: true,
// //                 pauseOnHover: true,
// //                 draggable: true,
// //                 progress: undefined,
// //                 theme: 'dark',
// //               });
// //         }
// //         // Your form submission logic goes here
// //         // Call API, dispatch an action, etc.
// //     };
// //     return (
// //         <>

// //             <div className="signup-container">
// //                 <h1 class="h1">Create an Account</h1>
// //                 <form className="signup-form" onSubmit={handleSubmit}>
// //                     <label htmlFor="fullname">Full Name:</label>
// //                     <input type="text"
// //                         id="fullname"
// //                         name="fullname"
// //                         value={formData.fullname}
// //                         onChange={handleInputChange}
// //                         required />

// //                     <label htmlFor="email">Email:</label>
// //                     <input type="email"
// //                         id="email"
// //                         name="email"
// //                         value={formData.email}
// //                         onChange={handleInputChange}
// //                         required />

// //                     <label htmlFor="password" class="pass">Password:</label>
// //                     <input type="password"
// //                         id="password"
// //                         name="password"
// //                         value={formData.password}
// //                         onChange={handleInputChange}
// //                         required
// //                     />

// //                     <label htmlFor="phone">Phone Number:</label>
// //                     <input type="tel"
// //                         id="phone"
// //                         name="phone"
// //                         value={formData.phone}
// //                         onChange={handleInputChange}
// //                         placeholder="123-456-7890" />

// //                     <Link to="/" element={<SignUp />}><button type="submit" class="signup">Sign Up</button></Link>
// //                 </form>
// //                 <ToastContainer />
// //                 <div className="alternative-signup">
// //                     <p>Or sign up using:</p>
// //                     <button className="google-btn">Sign Up with Google</button>
// //                     <button className="facebook-btn">Sign Up with Facebook</button>
// //                 </div>
// //             </div>
// //             <div className="image-container">
// //             </div>
// //         </>
// //     );
// // };
// // export default SignUp;

// import { Link } from 'react-router-dom';

// import { useState } from 'react';
// import { toast, ToastContainer } from 'react-toastify';
// import 'react-toastify/dist/ReactToastify.css';

// const SignUp = () => {
//     const [formData, setFormData] = useState({
//         fullname: '',
//         email: '',
//         password: '',
//         phone: ''
//     });

//     const handleInputChange = (event) => {
//         const { name, value } = event.target;
//         setFormData({ ...formData, [name]: value });
//     };

//     const handleSubmit = async (event) => {
//         event.preventDefault();
//         try {
//             const response = await fetch('/sojournquest/signup', {
//                 method: 'POST',
//                 headers: {
//                     'Content-Type': 'application/json',
//                 },
//                 body: JSON.stringify(formData),
//             });

//             if (!response.ok) {
//                 throw new Error('Failed to sign up');
//             }

//             // Handle successful sign-up
//             toast.success('Sign up successful', {
//                 position: 'top-center',
//                 autoClose: 5000,
//                 hideProgressBar: false,
//                 closeOnClick: true,
//                 pauseOnHover: true,
//                 draggable: true,
//                 progress: undefined,
//                 theme: 'dark',
//             });
//             // Reset form after successful sign-up
//             setFormData({
//                 fullname: '',
//                 email: '',
//                 password: '',
//                 phone: ''
//             });
//         } catch (error) {
//             // Handle sign-up error
//             toast.error(error.message || 'Sign-up failed', {
//                 position: 'top-center',
//                 autoClose: 5000,
//                 hideProgressBar: false,
//                 closeOnClick: true,
//                 pauseOnHover: true,
//                 draggable: true,
//                 progress: undefined,
//                 theme: 'dark',
//             });
//         }
//     };

//     return (
//         <>
//             <div className="signup-container">
//                 <h1 class="h1">Create an Account</h1>
//                 <form className="signup-form" onSubmit={handleSubmit}>
//                     <label htmlFor="fullname">Full Name:</label>
//                     <input type="text"
//                         id="fullname"
//                         name="fullname"
//                         value={formData.fullname}
//                         onChange={handleInputChange}
//                         required />

//                     <label htmlFor="email">Email:</label>
//                     <input type="email"
//                         id="email"
//                         name="email"
//                         value={formData.email}
//                         onChange={handleInputChange}
//                         required />

//                     <label htmlFor="password" class="pass">Password:</label>
//                     <input type="password"
//                         id="password"
//                         name="password"
//                         value={formData.password}
//                         onChange={handleInputChange}
//                         required
//                     />

//                     <label htmlFor="phone">Phone Number:</label>
//                     <input type="tel"
//                         id="phone"
//                         name="phone"
//                         value={formData.phone}
//                         onChange={handleInputChange}
//                         placeholder="123-456-7890" />

//                     <button type="submit" class="signup">Sign Up</button>
//                 </form>
//                 <ToastContainer />
//                 <div className="alternative-signup">
//                     <p>Or sign up using:</p>
//                     <button className="google-btn">Sign Up with Google</button>
//                     <button className="facebook-btn">Sign Up with Facebook</button>
//                 </div>
//             </div>
//             <div className="image-container">
//             </div>
//         </>
//     );
// };
// export default SignUp;




import { useState } from 'react';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';

const SignUp = () => {
    const [formData, setFormData] = useState({
        fullnamename: '',
        email: '',
        password: '',
        phone: ''
    });

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };
    

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/sojournquest/signup', formData);
            
                toast.success('Sign up successful', {
                    position: 'top-center',
                    autoClose: 5000,
                    hideProgressBar: false,
                    closeOnClick: true,
                    pauseOnHover: true,
                    draggable: true,
                    progress: undefined,
                    theme: 'dark',
                });
                setTimeout(() => {
                    window.location.href = '/signin';
                  }, 2000);

        } catch (error) {
            // Handle sign-up error
            toast.error(error.response.data, {
                position: 'top-center',
                autoClose: 5000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
                progress: undefined,
                theme: 'dark',
            });
            window.location.href = '/signin';
        }
    };

    return (
        <>
            <div className="signup-container">
                <h1 class="h1">Create an Account</h1>
                <form className="signup-form" onSubmit={handleSubmit}>
                    <label htmlFor="fullname">Full Name:</label>
                    <input type="text"
                        id="fullname"
                        name="fullname"
                        value={formData.fullname}
                        onChange={handleInputChange}
                        required />

                    <label htmlFor="email">Email:</label>
                    <input type="email"
                        id="email"
                        name="email"
                        value={formData.email}
                        onChange={handleInputChange}
                        required />

                    <label htmlFor="password" class="pass">Password:</label>
                    <input type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleInputChange}
                        required
                    />

                    <label htmlFor="phone">Phone Number:</label>
                    <input type="tel"
                        id="phone"
                        name="phone"
                        value={formData.phone}
                        onChange={handleInputChange}
                        placeholder="123-456-7890" />

                    <button type="submit" class="signup">Sign Up</button>
                </form>
                <ToastContainer />
                <div className="alternative-signup">
                    <p>Or sign up using:</p>
                    <button className="google-btn">Sign Up with Google</button>
                    <button className="facebook-btn">Sign Up with Facebook</button>
                </div>
            </div>
            <div className="image-container">
            </div>
        </>
    );
};
export default SignUp;
