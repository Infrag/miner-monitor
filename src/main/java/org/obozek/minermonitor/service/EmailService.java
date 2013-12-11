/*
 * Project: PMA :: pma-app
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Dec 11, 2012
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.obozek.minermonitor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author Ondrej.Bozek
 */
//@Service
public class EmailService
{

    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String PLAIN_EXTENSION = ".txt";
    public static final String HTML_EXTENSION = ".html";
    public static final Long ADMINISTRATOR_ID = 0L;
    @Autowired
    private JavaMailSender mailSender;
    /**
     * E-mail templates
     */
    @Autowired
    @Qualifier(value = "novaZadostToPorizovatel")
    private SimpleMailMessage novaZadostToPorizovatel;
    //
    @Value("${email.sender}")
    public static final String ZADOST_DETAIL_URL = "/zadost/Detail-zadosti-o-vydej-";
    public static final String PASPORT_DETAIL_URL = "/main/list-pasport/list-pasport-";

    /**
     *
     * @param zadostDTO
     * @param porizovatele
     */
//    public void sendMinerIsOffline(VydejZadostDTO zadostDTO, List<PorizovatelDTO> porizovatele)
//            throws MailException, MessagingException {
//        if (porizovatele != null && !porizovatele.isEmpty()) {
//            SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(novaZadostToPorizovatel);
//            String[] emailsTo = porizovatele.get(0).getKontaktniMail().split(";|,");
//            trimEmailStrings(emailsTo);
//            novaZadostPorizovatele.setTo(emailsTo);
//            if (porizovatele.size() > 1) {
//                List<String> bcc = new ArrayList<>();
//                for (int i = 1; i < porizovatele.size(); i++) {
//                    emailsTo = porizovatele.get(i).getKontaktniMail().split(";|,");
//                    trimEmailStrings(emailsTo);
//                    bcc.addAll(Arrays.asList(emailsTo));
//                }
//                novaZadostPorizovatele.setBcc(bcc.toArray(new String[]{}));
//            }
//            String zadostUrl = getZadostUrl(zadostDTO.getSid());
//            ZadatelDTO zadatel = zadostDTO.getZadatel();
//            novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(novaZadostPorizovatele.getText(),
//                    zadostDTO.getSid(), zadostUrl, zadostUrl));
//            sendEmail(novaZadostPorizovatele);
//        }
//    }
//
//    /**
//     *
//     * @param zadostDTO
//     */
//    public void sendSchvalenaZadostToZadatel(VydejZadostDTO zadostDTO, List<FileDTO> protokoly)
//            throws MailException, MessagingException, IOException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(schvalenaZadostToZadatel);
//        String[] emails = zadostDTO.getEmailNotifikace().split(";|,");
//        trimEmailStrings(emails);
//        
//        // TODO FIXME - fix this cast
//        novaZadostPorizovatele.setTo(emails);
//        String zadostUrl = getZadostUrl(zadostDTO.getSid());
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), zadostDTO.getSid(), zadostUrl, zadostUrl));
//        sendMultipleAttachementEmail(novaZadostPorizovatele, protokoly, true);
//    }
//
//    /**
//     *
//     * @param zadostDTO
//     */
//    public void sendZamitnutaZadostToZadatel(VydejZadostDTO zadostDTO, PorizovatelDTO zamitl)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(zamitnutaZadostToZadatel);
//        String[] emails = zadostDTO.getEmailNotifikace().split(";|,");
//        trimEmailStrings(emails);
//        
//        novaZadostPorizovatele.setTo(emails);
//        String zadostUrl = getZadostUrl(zadostDTO.getSid());
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), zadostDTO.getSid(), zamitl.getPopis(),
//                zamitl.getKontaktniMail(), zadostUrl, zadostUrl));
//        sendEmail(novaZadostPorizovatele);
//    }
//
//    private String getZadostUrl(BigDecimal zadostSid)
//    {
//        return vydejZadostUrl + ZADOST_DETAIL_URL + zadostSid;
//    }
//
//    private String getPasportUrl(BigDecimal pasportSid)
//    {
//        return pasportUrl + PASPORT_DETAIL_URL + pasportSid;
//    }
//
//    /**
//     *
//     * @param zadostDTO
//     * @param porizovatele
//     */
//    public void sendNovaZadostToZadatel(VydejZadostDTO zadostDTO, List<PorizovatelDTO> porizovatele)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostZadatel = new SimpleMailMessage(novaZadostToZadatel);
//        String[] emails = zadostDTO.getEmailNotifikace().split(";|,");
//        trimEmailStrings(emails);
//        
//        novaZadostZadatel.setTo(emails);
//        String zadostUrl = getZadostUrl(zadostDTO.getSid());
//        if (porizovatele != null && !porizovatele.isEmpty()) {
//            String porizovateleString = "", concatString = " ";
//            for (int i = 0; i < porizovatele.size(); i++) {
//                porizovateleString += concatString + porizovatele.get(i).getPopis();
//                concatString = ", <br/> ";
//            }
//            novaZadostZadatel.setText(novaZadostZadatel.getText().format(novaZadostZadatel.getText(),
//                    zadostDTO.getSid(), porizovateleString, zadostUrl, zadostUrl));
//        }
//        sendEmail(novaZadostZadatel);
//    }
//
//    /**
//     * Notify administrator about new user registered to application
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendUserRegistrationNotice(String role, Long userRoleId, String username)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(newUserRegisteredNotice);
//        SecUser admin = uzivatelService.getUser(ADMINISTRATOR_ID);
//
//        novaZadostPorizovatele.setTo(admin.getEmail());
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), role, userRoleId, username));
//
//        sendEmail(novaZadostPorizovatele);
//    }
//
//    /**
//     * Send Protokol o Predani to Zadatel
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendProtokol2Zadatel(VydejVyjadreniDTO vydejVyjadreni, FileDTO protokol)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(sendProtokol2Zadatel);
//        String[] emails = vydejVyjadreni.getZadost().getEmailNotifikace().split(";|,");
//        trimEmailStrings(emails);
//        
//        String zadostUrl = getZadostUrl(vydejVyjadreni.getZadost().getSid());
//        novaZadostPorizovatele.setTo(emails);
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), vydejVyjadreni.getPorizovatel().getPopis(),
//                vydejVyjadreni.getZadost().getSid(), zadostUrl, zadostUrl));
//
//        sendEmail(novaZadostPorizovatele, protokol);
//    }
//
//    /**
//     * Send Protokol o Predani to Zadatel
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendProtokol2ZadatelAllDone(VydejZadostDTO vydejZadost)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(sendProtokol2ZadatelAllDone);
//        String[] emails = vydejZadost.getEmailNotifikace().split(";|,");
//        trimEmailStrings(emails);
//        
//        String zadostUrl = getZadostUrl(vydejZadost.getSid());
//        novaZadostPorizovatele.setTo(emails);
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), vydejZadost.getSid(), zadostUrl, zadostUrl));
//
//        sendEmail(novaZadostPorizovatele);
//    }
//
//    /**
//     * Send notifikace porzovateli o novem 3. oddilu
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendNew3OddilToPorizovatel(PasportDTO pasport, PoskytovatelDTO poskytovatel)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage send2Porizovatel = new SimpleMailMessage(sendNew3OddilToPorizovatel);
//
//        String zadostUrl = getPasportUrl(pasport.getSid());
//        String[] emailsTo = pasport.getPorizovatel().getKontaktniMail().split(";|,");
//        trimEmailStrings(emailsTo);
//        
//        send2Porizovatel.setTo(emailsTo);
//        send2Porizovatel.setText(String.format(send2Porizovatel.getText(),
//                poskytovatel.getKontaktniOsoba(), pasport.getSid(), zadostUrl, zadostUrl));
//        sendEmail(send2Porizovatel);
//    }
//
//    /**
//     * Send notifikace porzovateli o novem 3. oddilu
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendCallForVerification(PasportDTO pasport, List<Porizovatel> porizovatele, BigDecimal transactionSid)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage send2Porizovatel = new SimpleMailMessage(callForVerification);
//
//        String browserUrl = browserTransactionUrl + transactionSid;
//        send2Porizovatel.setText(String.format(send2Porizovatel.getText(), pasport.getSpravce().getNazev(),
//                pasport.getSid(), pasport.getPoskytovatel().getZkratka(), browserUrl, browserUrl));
//        for (Porizovatel porizovatel : porizovatele) {
//            send2Porizovatel.setSubject(String.format(send2Porizovatel.getSubject(), porizovatel.getPopis()));
//            String[] emails = porizovatel.getKontaktniMail().split(";|,");
//            trimEmailStrings(emails);
//            send2Porizovatel.setTo(emails);
//            sendEmail(send2Porizovatel);
//        }
//    }
//
//    /**
//     * Send notification to all porizovatele that new Zadost data export is
//     * finished
//     *
//     * @param role
//     * @param userRoleId
//     * @param username
//     * @throws MailException
//     * @throws MessagingException
//     */
//    public void sendExportFinishedNotification(BigDecimal vydejZadostSid, List<Porizovatel> porizovatele)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage novaZadostPorizovatele = new SimpleMailMessage(sendExportFinishedNotification);
//
//
//        String zadostUrl = getZadostUrl(vydejZadostSid);
//        String[] emailsTo = porizovatele.get(0).getKontaktniMail().split(";|,");
//        trimEmailStrings(emailsTo);
//        novaZadostPorizovatele.setTo(emailsTo);
//        if (porizovatele.size() > 1) {
//            List<String> bcc = new ArrayList<>();
//            for (int i = 1; i < porizovatele.size(); i++) {
//                emailsTo = porizovatele.get(i).getKontaktniMail().split(";|,");
//                trimEmailStrings(emailsTo);
//                bcc.addAll(Arrays.asList(emailsTo));
//            }
//            novaZadostPorizovatele.setBcc(bcc.toArray(new String[]{}));
//        }
//        novaZadostPorizovatele.setText(novaZadostPorizovatele.getText().format(
//                novaZadostPorizovatele.getText(), vydejZadostSid, zadostUrl, zadostUrl));
//
//        sendEmail(novaZadostPorizovatele);
//    }
//
//    public void sendVerifikaceRejectedToSpravce(SpravceDTO spravce, AsPasportVerifikaceDTO verifikace)
//            throws MailException, MessagingException
//    {
//        SimpleMailMessage verifikaceRejected = new SimpleMailMessage(sendVerifikaceRejectedToPorizovatel);
//        verifikaceRejected.setTo(spravce.getKontaktniMail());
//        verifikaceRejected.setText(verifikaceRejected.getText().format(verifikaceRejected.getText(),
//                verifikace.getPasport().getSid(), verifikace.getPasport().getPoskytovatel().getZkratka(),
//                verifikace.getPorizovatel().getPopis(), verifikace.getVyjadreni()));
//        sendEmail(verifikaceRejected);
//    }
//
//    public void sendNewPoskytovatelRequest(PoskytovatelDTO poskytovatel, Long userId) throws MailException, MessagingException
//    {
//        SecUser admin = uzivatelService.getUser(ADMINISTRATOR_ID);
//
//        SimpleMailMessage newPoskytovatelMessage = new SimpleMailMessage(sendNewPoskytovatelRequest);
//        newPoskytovatelMessage.setTo(admin.getEmail());
//        newPoskytovatelMessage.setText(newPoskytovatelMessage.getText().format(newPoskytovatelMessage.getText(),
//                userId, convertNullToEmpty(poskytovatel.getIco()), convertNullToEmpty(poskytovatel.getNazev()), convertNullToEmpty(poskytovatel.getAdresa()),
//                convertNullToEmpty(poskytovatel.getOpravnenaOsoba()), convertNullToEmpty(poskytovatel.getKontaktOpravOsoba()),
//                convertNullToEmpty(poskytovatel.getKontaktniOsoba()), convertNullToEmpty(poskytovatel.getKontaktKontOsoba())));
//        sendEmail(newPoskytovatelMessage);
//    }
//
//    private String convertNullToEmpty(String string)
//    {
//        if (string == null) {
//            return "";
//        }
//        return string;
//    }
//    
//    private void trimEmailStrings(String[] emailsTo) 
//    {
//        for (int i = 0; i < emailsTo.length; i++) {
//            emailsTo[i] = emailsTo[i].trim();
//        }
//    }
//
//    public void sendEmail(SimpleMailMessage mailMessage) throws MailException, MessagingException
//    {
//        sendEmail(mailMessage, null, true);
//    }
//
//    public void sendEmail(SimpleMailMessage mailMessage, FileDTO attachment) throws MailException, MessagingException
//    {
//        sendEmail(mailMessage, attachment, true);
//    }
//
//    public void sendEmail(SimpleMailMessage mailMessage, Boolean textIsHtml) throws MailException, MessagingException
//    {
//        sendEmail(mailMessage, null, textIsHtml);
//    }
//
//    public void sendEmail(SimpleMailMessage mailMessage, FileDTO attachment, Boolean textIsHtml) throws MailException, MessagingException
//    {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, DEFAULT_ENCODING);
//
//        if (attachment != null) {
//            InputStreamSource is;
//            if (attachment.isInputStreamAvailable()) {
//                helper.addAttachment(attachment.getFileName(), new InputStreamResource(attachment.getDataStreamer().upload()));
//            } else {
//                helper.addAttachment(attachment.getFileName(), new ByteArrayResource(attachment.getContent()));
//            }
//        }
//
//        setMessageDetails(mailMessage, helper, textIsHtml);
//
//        this.mailSender.send(mimeMessage);
//    }
//
//    public void sendMultipleAttachementEmail(SimpleMailMessage mailMessage,
//            List<FileDTO> attachments, Boolean textIsHtml)
//            throws MailException, MessagingException, IOException
//    {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, DEFAULT_ENCODING);
//
//        if (attachments != null && !attachments.isEmpty()) {
//            for (FileDTO file : attachments) {
//                InputStreamSource is;
//                if (file.isInputStreamAvailable()) {
//                    helper.addAttachment(file.getFileName(), new InputStreamResource(file.getDataStreamer().upload()));
//                } else if (file.isOutputStreaAvailable()) {
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    file.getDataStreamer().stream(baos);
//                    helper.addAttachment(file.getFileName(), new ByteArrayResource(baos.toByteArray()));
//                } else {
//                    helper.addAttachment(file.getFileName(), new ByteArrayResource(file.getContent()));
//
//                }
//            }
//        }
//
//        setMessageDetails(mailMessage, helper, textIsHtml);
//
//        this.mailSender.send(mimeMessage);
//    }
//
//    private void setMessageDetails(SimpleMailMessage mailMessage, MimeMessageHelper helper, Boolean textIsHtml) throws MessagingException
//    {
//        if (mailMessage.getFrom() != null) {
//            helper.setFrom(mailMessage.getFrom());
//        }
//
//        if (mailMessage.getTo() != null) {
//            helper.setTo(mailMessage.getTo());
//        }
//
//        if (mailMessage.getReplyTo() != null) {
//            helper.setReplyTo(mailMessage.getReplyTo());
//        }
//
//        if (mailMessage.getBcc() != null) {
//            helper.setBcc(mailMessage.getBcc());
//        }
//
//        if (mailMessage.getCc() != null) {
//            helper.setCc(mailMessage.getCc());
//        }
//
//        if (mailMessage.getText() != null) {
//            helper.setText(mailMessage.getText(), textIsHtml);
//        }
//
//        if (mailMessage.getSubject() != null) {
//            helper.setSubject(mailMessage.getSubject());
//        }
//
//        if (mailMessage.getSentDate() != null) {
//            helper.setSentDate(mailMessage.getSentDate());
//        }
//    }
}
